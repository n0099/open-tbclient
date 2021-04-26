package com.baidu.nps.runtime;
/* loaded from: classes2.dex */
public class InitException extends RuntimeException {
    public int mErrorCode;
    public String mErrorMsg;

    public InitException(int i2, String str) {
        this.mErrorCode = i2;
        this.mErrorMsg = str;
    }

    public int errCode() {
        return this.mErrorCode;
    }

    public String errMsg() {
        return this.mErrorMsg;
    }
}
