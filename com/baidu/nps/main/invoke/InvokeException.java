package com.baidu.nps.main.invoke;
/* loaded from: classes2.dex */
public class InvokeException extends RuntimeException {
    public int mErrCode;
    public String mErrMsg;

    public InvokeException(int i2, String str) {
        this.mErrCode = i2;
        this.mErrMsg = str;
    }

    public int errCode() {
        return this.mErrCode;
    }

    public String errMsg() {
        return this.mErrMsg;
    }
}
