package com.baidu.searchbox.afx.callback;
/* loaded from: classes6.dex */
public class ErrorInfo {
    public static final int ERROR_DECODE = 16;
    public static final int ERROR_GL = 2;
    public static final int ERROR_PARAMS = 4;
    public static final int ERROR_SOURCE = 1;
    public static final int ERROR_UNKNOW = 8;
    public Exception mE;
    public int mErrorCode;
    public String mErrorMsg;

    public ErrorInfo(int i, String str, Exception exc) {
        this.mErrorCode = i;
        this.mErrorMsg = str;
        this.mE = exc;
    }
}
