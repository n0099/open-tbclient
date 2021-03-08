package com.baidu.swan.games.c;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class f {
    public static String aVP() {
        return com.baidu.swan.apps.storage.c.h.aMk().getString("get_app_console_core", "-1");
    }

    public static void wx(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.aMk().putString("get_app_console_core", str);
    }

    public static void aVQ() {
        wx("-1");
    }
}
