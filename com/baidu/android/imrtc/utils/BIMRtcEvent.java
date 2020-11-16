package com.baidu.android.imrtc.utils;
/* loaded from: classes18.dex */
public class BIMRtcEvent {
    public int requestAction = -1;
    public String requestRoomId = "-1";
    public int notifyAction = -1;
    public String notifyRoomId = "-1";
    public long notifySeqId = -1;
    public int sdkAction = -1;
    public String sdkRoomId = "-1";
    public long sdkSeqId = -1;
    public int serverAction = -1;
    public String serverRoomId = "-1";
    public long serverSedId = -1;

    public String toString() {
        return "BIMRtcEvent——Action,RoomId,SeqId {request: " + this.requestAction + ", " + this.requestRoomId + "; sdk: " + this.sdkAction + ", " + this.sdkRoomId + ", " + this.sdkSeqId + "; server: " + this.serverAction + ", " + this.serverRoomId + ", " + this.serverSedId + "; notify: " + this.notifyAction + ", " + this.notifyRoomId + ", " + this.notifySeqId + '}';
    }
}
