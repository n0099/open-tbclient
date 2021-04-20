package com.baidu.adp.framework.message;

import com.baidu.tbadk.core.util.TbErrInfo;
import d.b.c.c.e.c.h;
import d.b.c.c.i.a;
/* loaded from: classes.dex */
public abstract class ResponsedMessage<T> {
    public final int mCmd;
    public Message<?> mOrginalMessage;
    public int mError = 0;
    public String mErrorString = null;
    public long mStartTime = 0;
    public long mProcessTime = 0;
    public int mDownSize = 0;
    public long mCostTime = 0;
    public a performanceData = new a();

    public ResponsedMessage(int i) {
        this.mCmd = i;
    }

    public void afterDispatchInBackGround(int i, T t) {
    }

    public void beforeDispatchInBackGround(int i, T t) {
    }

    public abstract /* synthetic */ void decodeInBackGround(int i, T t) throws Exception;

    public int getCmd() {
        return this.mCmd;
    }

    public long getCostTime() {
        return this.mCostTime;
    }

    public int getDownSize() {
        return this.mDownSize;
    }

    public int getError() {
        return this.mError;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public Message<?> getOrginalMessage() {
        return this.mOrginalMessage;
    }

    public long getProcessTime() {
        return this.mProcessTime;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public Message<?> getmOrginalMessage() {
        return this.mOrginalMessage;
    }

    public abstract boolean hasError();

    public void onDecodeFailedInBackGround(int i, T t, int i2) throws Exception {
        if (i2 == h.f42014c) {
            setError(TbErrInfo.ERR_SOKCET_SWITCH_HTTP);
        }
    }

    public void setCostTime(long j) {
        this.mCostTime = j;
    }

    public void setDownSize(int i) {
        this.mDownSize = i;
    }

    public void setError(int i) {
        this.mError = i;
    }

    public void setErrorString(String str) {
        this.mErrorString = str;
    }

    public void setOrginalMessage(Message<?> message) {
        this.mOrginalMessage = message;
    }

    public void setProcessTime(long j) {
        this.mProcessTime = j;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setmOrginalMessage(Message<?> message) {
        this.mOrginalMessage = message;
    }
}
