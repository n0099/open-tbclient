package com.baidu.swan.games.c;

import android.support.annotation.NonNull;
/* loaded from: classes3.dex */
public class f {
    public static String aNz() {
        return com.baidu.swan.apps.storage.c.h.aDP().getString("get_app_console_core", "-1");
    }

    public static void vo(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.aDP().putString("get_app_console_core", str);
    }

    public static void aNA() {
        vo("-1");
    }
}
