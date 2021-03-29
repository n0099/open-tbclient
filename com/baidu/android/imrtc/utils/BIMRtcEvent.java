package com.baidu.android.imrtc.utils;

import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes.dex */
public class BIMRtcEvent {
    public static final int CREATE_ACTION = -10;
    public static final int TOKEN_ACTION = -11;
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
    public String ext = "";

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("BIMRtcEvent——Action,RoomId,SeqId {request: ");
        sb.append(this.requestAction);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(this.requestRoomId);
        sb.append("; sdk: ");
        sb.append(this.sdkAction);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(this.sdkRoomId);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(this.sdkSeqId);
        sb.append("; server: ");
        sb.append(this.serverAction);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(this.serverRoomId);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(this.serverSedId);
        sb.append("; notify: ");
        sb.append(this.notifyAction);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(this.notifyRoomId);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(this.notifySeqId);
        if (this.requestAction == -10) {
            str = ", ext: " + this.ext;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}
