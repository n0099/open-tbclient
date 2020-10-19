package com.baidu.swan.apps.ap;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes10.dex */
public class ag {
    public static boolean tL(String str) {
        return ca(com.baidu.swan.apps.swancore.b.ti(str));
    }

    public static boolean ca(long j) {
        SwanCoreVersion anI = com.baidu.swan.apps.core.turbo.d.ann().anI();
        long j2 = anI != null ? anI.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.i("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
