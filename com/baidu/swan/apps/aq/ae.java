package com.baidu.swan.apps.aq;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes11.dex */
public class ae {
    public static boolean pT(String str) {
        return bz(com.baidu.swan.apps.swancore.b.pq(str));
    }

    public static boolean bz(long j) {
        SwanCoreVersion acM = com.baidu.swan.apps.core.turbo.d.acr().acM();
        long j2 = acM != null ? acM.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.d("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
