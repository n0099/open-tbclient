package com.baidu.afd;
/* loaded from: classes.dex */
public class ParseError extends Exception {
    public static final int ERROR_INVALID_DATA = 2;
    public static final int ERROR_INVALID_JSON_ROOT = 1;
    public static final int ERROR_OK = 0;
    public static final ParseError ERROR_SMOOTH_SCROLL = new ParseError(4, "");
    public final int errorCode;
    public final String errorMessage;
    public String tplName = "";

    public ParseError(int i, String str) {
        this.errorCode = i;
        this.errorMessage = str;
    }
}
