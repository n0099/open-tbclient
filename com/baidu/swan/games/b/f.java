package com.baidu.swan.games.b;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class f {
    public static String akT() {
        return com.baidu.swan.apps.storage.c.h.adb().getString("get_app_console_core", "-1");
    }

    public static void ot(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.adb().putString("get_app_console_core", str);
    }

    public static void akU() {
        ot("-1");
    }
}
