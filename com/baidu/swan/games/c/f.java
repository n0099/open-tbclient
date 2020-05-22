package com.baidu.swan.games.c;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class f {
    public static String azo() {
        return com.baidu.swan.apps.storage.c.h.arO().getString("get_app_console_core", "-1");
    }

    public static void rw(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.arO().putString("get_app_console_core", str);
    }

    public static void azp() {
        rw("-1");
    }
}
