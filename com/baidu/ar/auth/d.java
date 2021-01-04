package com.baidu.ar.auth;

import android.content.Context;
import com.baidu.ar.h.n;
/* loaded from: classes6.dex */
class d {
    private static int jB = 0;

    public static boolean cx() {
        if (jB == 0) {
            try {
                Class.forName("com.baidu.aip.auth.Auth");
                com.baidu.ar.libloader.a.require("aip-native-auth");
                jB = 1;
            } catch (Throwable th) {
                jB = -1;
            }
        }
        return jB == 1;
    }

    public static String l(Context context) {
        Object aV = n.aV("com.baidu.aip.auth.Auth");
        return aV != null ? (String) n.a(aV, "com.baidu.aip.auth.Auth", "getToken", context, Context.class) : "";
    }
}
