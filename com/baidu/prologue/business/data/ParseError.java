package com.baidu.prologue.business.data;
/* loaded from: classes19.dex */
public class ParseError extends Exception {
    public static final int ERROR_INVALID_DATA = 2;
    public static final int ERROR_INVALID_JSON_ROOT = 1;
    public static final int ERROR_OK = 0;
    public final int errorCode;
    public final String errorMessage;

    public ParseError(int i, String str) {
        this.errorCode = i;
        this.errorMessage = str;
    }
}
