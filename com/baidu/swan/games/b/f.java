package com.baidu.swan.games.b;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class f {
    public static String anm() {
        return com.baidu.swan.apps.storage.c.h.afu().getString("get_app_console_core", "-1");
    }

    public static void oH(@NonNull String str) {
        com.baidu.swan.apps.storage.c.h.afu().putString("get_app_console_core", str);
    }

    public static void ann() {
        oH("-1");
    }
}
