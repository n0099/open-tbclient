package com.baidu.android.imsdk.chatmessage.sync;
/* loaded from: classes9.dex */
public class DialogRecord {
    public static final int STATE_COMPLETE = 1;
    public static final int STATE_NEED_FETCHING = 0;
    private int category;
    private long contacter;
    private long maxMsgid;
    private int state;
    private long updateTime;
    private int jumpToRecent = 1;
    private long dialogueMsgid = 0;

    public int getCategory() {
        return this.category;
    }

    public DialogRecord setCategory(int i) {
        this.category = i;
        return this;
    }

    public long getContacter() {
        return this.contacter;
    }

    public DialogRecord setContacter(long j) {
        this.contacter = j;
        return this;
    }

    public long getMaxMsgid() {
        return this.maxMsgid;
    }

    public DialogRecord setMaxMsgid(long j) {
        if (j > this.maxMsgid) {
            this.maxMsgid = j;
        }
        return this;
    }

    public int getState() {
        return this.state;
    }

    public DialogRecord setState(int i) {
        this.state = i;
        return this;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public DialogRecord setUpdateTime(long j) {
        this.updateTime = j;
        return this;
    }

    public int getJumpToRecent() {
        return this.jumpToRecent;
    }

    public DialogRecord setJumpToRecent(int i) {
        this.jumpToRecent = i;
        return this;
    }

    public long getDialogueMsgid() {
        return this.dialogueMsgid;
    }

    public DialogRecord setDialogueMsgid(long j) {
        this.dialogueMsgid = j;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DialogRecord[").append("category=").append(this.category).append(",contacter=").append(this.contacter).append(",maxMsgid=").append(this.maxMsgid).append(",state=").append(this.state).append(",updateTime=").append(this.updateTime).append(",jumpToRecent=").append(this.jumpToRecent).append(",dialogueMsgid=").append(this.dialogueMsgid).append("]");
        return sb.toString();
    }
}
