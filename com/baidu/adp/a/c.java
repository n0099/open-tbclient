package com.baidu.adp.a;
/* loaded from: classes.dex */
public abstract class c {
    public static final int MODE_INVALID = 0;
    protected int mLoadDataMode = 0;
    protected e mLoadDataCallBack = null;
    protected int mErrorCode = 0;
    protected String mErrorString = null;

    protected abstract boolean LoadData();

    public abstract boolean cancelLoadData();

    public int getLoadDataMode() {
        return this.mLoadDataMode;
    }

    public void setLoadDataCallBack(e eVar) {
        this.mLoadDataCallBack = eVar;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public void setErrorString(String str) {
        this.mErrorString = str;
    }
}
