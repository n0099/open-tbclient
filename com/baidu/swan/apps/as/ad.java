package com.baidu.swan.apps.as;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes10.dex */
public class ad {
    public static boolean mB(String str) {
        return aH(com.baidu.swan.apps.swancore.b.ma(str));
    }

    public static boolean aH(long j) {
        SwanCoreVersion OA = com.baidu.swan.apps.core.k.d.Og().OA();
        long j2 = OA != null ? OA.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.d("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
