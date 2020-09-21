package com.baidu.ar.auth;
/* loaded from: classes10.dex */
public class b {
    public static IAuthenticator getAsyncAuthenticator(String str, String str2, String str3) {
        return com.baidu.ar.auth.a.a.b(str, str2, str3);
    }

    public static IAuthenticator getAuthenticator() {
        return com.baidu.ar.auth.a.b.cF();
    }

    public static IOfflineAuthenticator getOfflineAuthenticator() {
        return com.baidu.ar.auth.a.c.cG();
    }
}
