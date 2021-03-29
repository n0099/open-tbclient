package com.baidu.android.imsdk.chatmessage;
/* loaded from: classes.dex */
public class MsgRecord {
    public long msgId;
    public long msgTime;

    public MsgRecord(long j, long j2) {
        this.msgId = j;
        this.msgTime = j2;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public void setMsgId(long j) {
        this.msgId = j;
    }

    public void setMsgTime(long j) {
        this.msgTime = j;
    }
}
