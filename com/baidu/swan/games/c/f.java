package com.baidu.swan.games.c;

import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class f {
    public static String aVM() {
        return com.baidu.swan.apps.storage.c.h.aMh().getString("get_app_console_core", "-1");
    }

    public static void wq(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.aMh().putString("get_app_console_core", str);
    }

    public static void aVN() {
        wq("-1");
    }
}
