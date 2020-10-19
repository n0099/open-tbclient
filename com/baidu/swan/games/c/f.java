package com.baidu.swan.games.c;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class f {
    public static String aQi() {
        return com.baidu.swan.apps.storage.c.h.aGy().getString("get_app_console_core", "-1");
    }

    public static void wa(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.aGy().putString("get_app_console_core", str);
    }

    public static void aQj() {
        wa("-1");
    }
}
