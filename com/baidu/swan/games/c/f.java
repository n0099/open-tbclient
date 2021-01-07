package com.baidu.swan.games.c;

import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class f {
    public static String aZu() {
        return com.baidu.swan.apps.storage.c.h.aPI().getString("get_app_console_core", "-1");
    }

    public static void xi(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.aPI().putString("get_app_console_core", str);
    }

    public static void aZv() {
        xi("-1");
    }
}
