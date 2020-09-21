package com.baidu.ar.auth;

import android.content.Context;
/* loaded from: classes10.dex */
class e {
    private static int jm = 0;

    public static boolean cy() {
        if (jm == 0) {
            try {
                Class.forName("com.baidu.aip.auth.Auth");
                com.baidu.ar.libloader.b.as("aip-native-auth");
                jm = 1;
            } catch (Throwable th) {
                jm = -1;
            }
        }
        return jm == 1;
    }

    public static String k(Context context) {
        Object aS = com.baidu.ar.g.n.aS("com.baidu.aip.auth.Auth");
        return aS != null ? (String) com.baidu.ar.g.n.a(aS, "com.baidu.aip.auth.Auth", "getToken", context, Context.class) : "";
    }
}
