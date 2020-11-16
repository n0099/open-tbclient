package com.baidu.swan.apps.ap;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes7.dex */
public class ag {
    public static boolean un(String str) {
        return cy(com.baidu.swan.apps.swancore.b.tK(str));
    }

    public static boolean cy(long j) {
        SwanCoreVersion arv = com.baidu.swan.apps.core.turbo.d.ara().arv();
        long j2 = arv != null ? arv.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.i("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
