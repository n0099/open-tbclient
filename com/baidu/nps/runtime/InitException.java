package com.baidu.nps.runtime;
/* loaded from: classes2.dex */
public class InitException extends RuntimeException {
    public int mErrorCode;
    public String mErrorMsg;

    public InitException(int i, String str) {
        this.mErrorCode = i;
        this.mErrorMsg = str;
    }

    public int errCode() {
        return this.mErrorCode;
    }

    public String errMsg() {
        return this.mErrorMsg;
    }
}
