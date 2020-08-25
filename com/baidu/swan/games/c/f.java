package com.baidu.swan.games.c;

import android.support.annotation.NonNull;
/* loaded from: classes8.dex */
public class f {
    public static String aMO() {
        return com.baidu.swan.apps.storage.c.h.aDf().getString("get_app_console_core", "-1");
    }

    public static void uU(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.aDf().putString("get_app_console_core", str);
    }

    public static void aMP() {
        uU("-1");
    }
}
