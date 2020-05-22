package com.baidu.swan.apps.aq;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes11.dex */
public class ae {
    public static boolean pL(String str) {
        return bz(com.baidu.swan.apps.swancore.b.pi(str));
    }

    public static boolean bz(long j) {
        SwanCoreVersion abG = com.baidu.swan.apps.core.turbo.d.abl().abG();
        long j2 = abG != null ? abG.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.d("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
