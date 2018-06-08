package com.baidu.aip.auth;
/* loaded from: classes3.dex */
public class AuthException extends Throwable {
    public static String a = "Load jni so library error";
    public static String b = "network error";
    public static String c = "token data error";
    private int mErrorCode;
    private String mMessage;

    public AuthException(int i, String str) {
        super(a(i, str));
        this.mErrorCode = i;
        this.mMessage = str;
    }

    private static String a(int i, String str) {
        return "[" + i + "] " + str;
    }
}
