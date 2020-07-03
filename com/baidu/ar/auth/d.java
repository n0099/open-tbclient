package com.baidu.ar.auth;

import android.content.Context;
/* loaded from: classes3.dex */
class d {
    private static int jA = 0;

    public static boolean ch() {
        if (jA == 0) {
            try {
                Class.forName("com.baidu.aip.auth.Auth");
                com.baidu.ar.libloader.b.ao("aip-native-auth");
                jA = 1;
            } catch (Throwable th) {
                jA = -1;
            }
        }
        return jA == 1;
    }

    public static String k(Context context) {
        Object aO = com.baidu.ar.f.l.aO("com.baidu.aip.auth.Auth");
        return aO != null ? (String) com.baidu.ar.f.l.a(aO, "com.baidu.aip.auth.Auth", "getToken", context, Context.class) : "";
    }
}
