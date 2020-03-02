package com.baidu.swan.games.b;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class f {
    public static String anj() {
        return com.baidu.swan.apps.storage.c.h.afr().getString("get_app_console_core", "-1");
    }

    public static void oI(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.afr().putString("get_app_console_core", str);
    }

    public static void ank() {
        oI("-1");
    }
}
