package com.baidu.swan.games.c;

import android.support.annotation.NonNull;
/* loaded from: classes7.dex */
public class f {
    public static String aDZ() {
        return com.baidu.swan.apps.storage.c.h.auW().getString("get_app_console_core", "-1");
    }

    public static void sD(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.auW().putString("get_app_console_core", str);
    }

    public static void aEa() {
        sD("-1");
    }
}
