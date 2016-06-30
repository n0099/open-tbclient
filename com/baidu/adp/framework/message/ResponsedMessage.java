package com.baidu.adp.framework.message;

import com.baidu.adp.framework.client.socket.j;
import com.baidu.tbadk.core.util.TbErrInfo;
/* loaded from: classes.dex */
public abstract class ResponsedMessage<T> implements a<T> {
    private final int mCmd;
    private Message<?> mOrginalMessage;
    private int mError = 0;
    private String mErrorString = null;
    private long mStartTime = 0;
    private long mProcessTime = 0;
    private int mDownSize = 0;
    private long mCostTime = 0;
    public b performanceData = new b();

    public abstract boolean hasError();

    public long getStartTime() {
        return this.mStartTime;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public long getProcessTime() {
        return this.mProcessTime;
    }

    public void setProcessTime(long j) {
        this.mProcessTime = j;
    }

    public Message<?> getmOrginalMessage() {
        return this.mOrginalMessage;
    }

    public void setmOrginalMessage(Message<?> message) {
        this.mOrginalMessage = message;
    }

    public int getError() {
        return this.mError;
    }

    public void setError(int i) {
        this.mError = i;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public void setErrorString(String str) {
        this.mErrorString = str;
    }

    public ResponsedMessage(int i) {
        this.mCmd = i;
    }

    public int getCmd() {
        return this.mCmd;
    }

    public Message<?> getOrginalMessage() {
        return this.mOrginalMessage;
    }

    public void setOrginalMessage(Message<?> message) {
        this.mOrginalMessage = message;
    }

    public void beforeDispatchInBackGround(int i, T t) {
    }

    public void afterDispatchInBackGround(int i, T t) {
    }

    public int getDownSize() {
        return this.mDownSize;
    }

    public void setDownSize(int i) {
        this.mDownSize = i;
    }

    public long getCostTime() {
        return this.mCostTime;
    }

    public void setCostTime(long j) {
        this.mCostTime = j;
    }

    public void onDecodeFailedInBackGround(int i, T t, int i2) {
        if (i2 == j.eU) {
            setError(TbErrInfo.ERR_SOKCET_SWITCH_HTTP);
        }
    }
}
