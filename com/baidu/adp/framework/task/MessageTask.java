package com.baidu.adp.framework.task;

import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import d.b.c.c.j.e;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class MessageTask {
    public final int mCmd;
    public int mPriority;
    public int mRetry;
    public e mTimeOut;
    public BdAsyncTaskParallel mParallel = null;
    public boolean mNeedEncrypt = true;

    public MessageTask(int i) {
        this.mCmd = i;
        check();
    }

    private void check() {
        if (!checkCmd()) {
            throw new InvalidParameterException("cmd invalid");
        }
    }

    public abstract boolean checkCmd();

    public int getCmd() {
        return this.mCmd;
    }

    public boolean getNeedEncrypt() {
        return this.mNeedEncrypt;
    }

    public BdAsyncTaskParallel getParallel() {
        return this.mParallel;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getRetry() {
        return this.mRetry;
    }

    public e getTimeOut() {
        return this.mTimeOut;
    }

    public void setNeedEncrypt(boolean z) {
        this.mNeedEncrypt = z;
    }

    public void setParallel(BdAsyncTaskParallel bdAsyncTaskParallel) {
        this.mParallel = bdAsyncTaskParallel;
    }

    public void setPriority(int i) {
        this.mPriority = i;
    }

    public void setRetry(int i) {
        this.mRetry = i;
    }

    public void setTimeOut(e eVar) {
        this.mTimeOut = eVar;
    }
}
