package com.baidu.swan.games.c;

import android.support.annotation.NonNull;
/* loaded from: classes7.dex */
public class f {
    public static String aTU() {
        return com.baidu.swan.apps.storage.c.h.aKk().getString("get_app_console_core", "-1");
    }

    public static void wC(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.aKk().putString("get_app_console_core", str);
    }

    public static void aTV() {
        wC("-1");
    }
}
