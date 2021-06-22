package com.baidu.android.imsdk.chatmessage.sync;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes.dex */
public class DialogRecord {
    public static final int STATE_COMPLETE = 1;
    public static final int STATE_NEED_FETCHING = 0;
    public int category;
    public long contacter;
    public long maxMsgid;
    public int state;
    public long updateTime;
    public int jumpToRecent = 1;
    public long dialogueMsgid = 0;

    public int getCategory() {
        return this.category;
    }

    public long getContacter() {
        return this.contacter;
    }

    public long getDialogueMsgid() {
        return this.dialogueMsgid;
    }

    public int getJumpToRecent() {
        return this.jumpToRecent;
    }

    public long getMaxMsgid() {
        return this.maxMsgid;
    }

    public int getState() {
        return this.state;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public DialogRecord setCategory(int i2) {
        this.category = i2;
        return this;
    }

    public DialogRecord setContacter(long j) {
        this.contacter = j;
        return this;
    }

    public DialogRecord setDialogueMsgid(long j) {
        this.dialogueMsgid = j;
        return this;
    }

    public DialogRecord setJumpToRecent(int i2) {
        this.jumpToRecent = i2;
        return this;
    }

    public DialogRecord setMaxMsgid(long j) {
        if (j > this.maxMsgid) {
            this.maxMsgid = j;
        }
        return this;
    }

    public DialogRecord setState(int i2) {
        this.state = i2;
        return this;
    }

    public DialogRecord setUpdateTime(long j) {
        this.updateTime = j;
        return this;
    }

    public String toString() {
        return "DialogRecord[category=" + this.category + ",contacter=" + this.contacter + ",maxMsgid=" + this.maxMsgid + ",state=" + this.state + ",updateTime=" + this.updateTime + ",jumpToRecent=" + this.jumpToRecent + ",dialogueMsgid=" + this.dialogueMsgid + PreferencesUtil.RIGHT_MOUNT;
    }
}
