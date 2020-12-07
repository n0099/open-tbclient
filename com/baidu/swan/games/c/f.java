package com.baidu.swan.games.c;

import android.support.annotation.NonNull;
/* loaded from: classes25.dex */
public class f {
    public static String aWZ() {
        return com.baidu.swan.apps.storage.c.h.aNr().getString("get_app_console_core", "-1");
    }

    public static void xj(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.aNr().putString("get_app_console_core", str);
    }

    public static void aXa() {
        xj("-1");
    }
}
