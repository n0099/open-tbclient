package com.baidu.android.imsdk.chatmessage;
/* loaded from: classes6.dex */
public class MsgRecord {
    private long msgId;
    private long msgTime;

    public MsgRecord(long j, long j2) {
        this.msgId = j;
        this.msgTime = j2;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public void setMsgId(long j) {
        this.msgId = j;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public void setMsgTime(long j) {
        this.msgTime = j;
    }
}
