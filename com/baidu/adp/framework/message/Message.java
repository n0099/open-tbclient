package com.baidu.adp.framework.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.a.b.a.a.i;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class Message<T> extends i {
    private final int mCmd;
    private Object mExtra = null;
    private long mStartTime = 0;
    private BdUniqueId mTag;

    public abstract boolean checkCmd(int i);

    public long getStartTime() {
        return this.mStartTime;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public Message(int i) {
        this.mCmd = i;
        check();
    }

    public Message(int i, BdUniqueId bdUniqueId) {
        this.mCmd = i;
        this.mTag = bdUniqueId;
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

    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public void setExtra(Object obj) {
        this.mExtra = obj;
    }
}
