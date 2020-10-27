package com.baidu.swan.games.c;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class f {
    public static String aSc() {
        return com.baidu.swan.apps.storage.c.h.aIs().getString("get_app_console_core", "-1");
    }

    public static void wt(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.aIs().putString("get_app_console_core", str);
    }

    public static void aSd() {
        wt("-1");
    }
}
