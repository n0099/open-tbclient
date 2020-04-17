package com.baidu.ar.auth;

import android.content.Context;
/* loaded from: classes3.dex */
class d {
    private static int jj = 0;

    public static boolean bR() {
        if (jj == 0) {
            try {
                Class.forName("com.baidu.aip.auth.Auth");
                com.baidu.ar.libloader.b.an("aip-native-auth");
                jj = 1;
            } catch (Throwable th) {
                jj = -1;
            }
        }
        return jj == 1;
    }

    public static String i(Context context) {
        Object aN = com.baidu.ar.f.l.aN("com.baidu.aip.auth.Auth");
        return aN != null ? (String) com.baidu.ar.f.l.a(aN, "com.baidu.aip.auth.Auth", "getToken", context, Context.class) : "";
    }
}
