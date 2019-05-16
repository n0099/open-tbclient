package com.baidu.swan.apps.an;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes2.dex */
public class y {
    public static boolean ii(String str) {
        return ab(com.baidu.swan.apps.swancore.b.hI(str));
    }

    public static boolean ab(long j) {
        SwanCoreVersion BA = com.baidu.swan.apps.core.j.c.Bi().BA();
        long j2 = BA != null ? BA.aVW : 0L;
        com.baidu.swan.apps.console.c.d("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
