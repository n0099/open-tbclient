package com.baidu.swan.games.b;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class f {
    public static String anh() {
        return com.baidu.swan.apps.storage.c.h.afp().getString("get_app_console_core", "-1");
    }

    public static void oI(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.afp().putString("get_app_console_core", str);
    }

    public static void ani() {
        oI("-1");
    }
}
