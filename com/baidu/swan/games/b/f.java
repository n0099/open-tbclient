package com.baidu.swan.games.b;

import android.support.annotation.NonNull;
/* loaded from: classes9.dex */
public class f {
    public static String akA() {
        return com.baidu.swan.apps.storage.c.h.acE().getString("get_app_console_core", "-1");
    }

    public static void oq(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.acE().putString("get_app_console_core", str);
    }

    public static void akB() {
        oq("-1");
    }
}
