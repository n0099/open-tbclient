package com.baidu.adp.framework.task;

import com.baidu.adp.framework.c.g;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class MessageTask {
    protected final int mCmd;
    protected int mPriority;
    protected int mRetry;
    protected g mTimeOut;

    public abstract boolean checkCmd();

    public MessageTask(int i) {
        this.mCmd = i;
        check();
    }

    private void check() {
        if (!checkCmd()) {
            throw new InvalidParameterException("cmd invalid");
        }
    }

    public int getCmd() {
        return this.mCmd;
    }

    public g getTimeOut() {
        return this.mTimeOut;
    }

    public void setTimeOut(g gVar) {
        this.mTimeOut = gVar;
    }

    public int getRetry() {
        return this.mRetry;
    }

    public void setRetry(int i) {
        this.mRetry = i;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public void setPriority(int i) {
        this.mPriority = i;
    }
}
