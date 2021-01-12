package com.baidu.swan.games.c;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class f {
    public static String aVA() {
        return com.baidu.swan.apps.storage.c.h.aLO().getString("get_app_console_core", "-1");
    }

    public static void vX(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.aLO().putString("get_app_console_core", str);
    }

    public static void aVB() {
        vX("-1");
    }
}
