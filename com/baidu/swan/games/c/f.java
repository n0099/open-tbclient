package com.baidu.swan.games.c;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class f {
    public static String aAu() {
        return com.baidu.swan.apps.storage.c.h.asV().getString("get_app_console_core", "-1");
    }

    public static void rE(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.asV().putString("get_app_console_core", str);
    }

    public static void aAv() {
        rE("-1");
    }
}
