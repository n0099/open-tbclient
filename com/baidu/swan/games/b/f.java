package com.baidu.swan.games.b;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class f {
    public static String avz() {
        return com.baidu.swan.apps.storage.c.h.anz().getString("get_app_console_core", "-1");
    }

    public static void pU(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.anz().putString("get_app_console_core", str);
    }

    public static void avA() {
        pU("-1");
    }
}
