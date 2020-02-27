package com.baidu.live.adp.framework.task;

import com.baidu.live.adp.framework.settings.TimeOutData;
import com.baidu.live.adp.lib.asynctask.BdAsyncTaskParallel;
import java.security.InvalidParameterException;
/* loaded from: classes3.dex */
public abstract class MessageTask {
    protected final int mCmd;
    protected int mPriority;
    protected int mRetry;
    protected TimeOutData mTimeOut;
    private BdAsyncTaskParallel mParallel = null;
    protected boolean mNeedEncrypt = true;

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

    public TimeOutData getTimeOut() {
        return this.mTimeOut;
    }

    public void setTimeOut(TimeOutData timeOutData) {
        this.mTimeOut = timeOutData;
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

    public BdAsyncTaskParallel getParallel() {
        return this.mParallel;
    }

    public void setParallel(BdAsyncTaskParallel bdAsyncTaskParallel) {
        this.mParallel = bdAsyncTaskParallel;
    }

    public boolean getNeedEncrypt() {
        return this.mNeedEncrypt;
    }

    public void setNeedEncrypt(boolean z) {
        this.mNeedEncrypt = z;
    }
}
