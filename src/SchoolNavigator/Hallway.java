package SchoolNavigator;

public class Hallway {
    public int id, entranceId, exitId;
    public Intersection entrance, exit;
    public Room[] rooms;
    public double length = 1;
    public String direction;
    boolean altered = false;

    public Hallway(){}
    public Hallway(int id) {
        this.id = id;
    }
    public Hallway(int id, Room[] rooms) {
        this.id = id;
        this.rooms = rooms;
        setHallways();
    }
    public Hallway(int id, Intersection entrance, Intersection exit, Room[] rooms, double length) {
        this.id = id;
        this.entrance = entrance;
        this.exit = exit;
        this.rooms = rooms;
        this.length = length;
        setHallways();
    }
    public Hallway(Intersection entrance, Intersection exit, String direction) {
        this.entrance = entrance;
        this.exit = exit;
        this.direction = direction;
    }
    public Hallway(Hallway hallway) {
        this.id = hallway.id;
        this.entrance = hallway.entrance;
        this.exit = hallway.exit;
        this.entranceId = hallway.entranceId;
        this.exitId = hallway.exitId;
        this.rooms = hallway.rooms;
        this.length = hallway.length;
        this.direction = hallway.direction;
        setHallways();
    }
    public void setUp(Intersection entrance, Intersection exit) {
        this.entrance = entrance;
        this.exit = exit;
    }
    public Intersection getEntrance() {
        return entrance;
    }
    public Intersection getExit() {
        return exit;
    }
    public Room[] getRooms() {
        return rooms;
    }
    public Room getRoomById(int id) {
        for(Room room : rooms) {
            if(room.id == id)
                return room;
        }
        return null;
    }
    public Intersection getOtherEnd(Intersection i) {
        if(entrance.equals(i))
            return exit;
        else if(exit.equals(i))
            return entrance;
        else
            return null;
    }
    private void setHallways() {
        for(Room room : rooms) {
            room.hallway = this;
        }
    }
}
