package com.baidu.adp.framework.message;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class Message<T> {
    private final int mCmd;
    private Object mExtra = null;
    private int mTag;

    public abstract boolean checkCmd(int i);

    public Message(int i) {
        this.mCmd = i;
        check();
    }

    public Message(int i, int i2) {
        this.mCmd = i;
        this.mTag = i2;
        check();
    }

    private void check() {
        if (!checkCmd(this.mCmd)) {
            throw new InvalidParameterException("cmd invalid");
        }
    }

    public int getCmd() {
        return this.mCmd;
    }

    public int getTag() {
        return this.mTag;
    }

    public void setTag(int i) {
        this.mTag = i;
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public void setExtra(Object obj) {
        this.mExtra = obj;
    }
}
