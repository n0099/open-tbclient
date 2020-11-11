package com.baidu.swan.games.c;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class f {
    public static String aUC() {
        return com.baidu.swan.apps.storage.c.h.aKS().getString("get_app_console_core", "-1");
    }

    public static void wH(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.aKS().putString("get_app_console_core", str);
    }

    public static void aUD() {
        wH("-1");
    }
}
