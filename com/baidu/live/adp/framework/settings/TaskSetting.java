package com.baidu.live.adp.framework.settings;
/* loaded from: classes10.dex */
public class TaskSetting {
    protected TimeOutData mTimeOutData = null;
    protected int mRetryCount = 1;

    public int getRetryCount() {
        return this.mRetryCount;
    }

    public void setRetryCount(int i) {
        if (i < 1) {
            i = 1;
        }
        this.mRetryCount = i;
    }

    public TimeOutData getTimeOutData() {
        return this.mTimeOutData;
    }
}
