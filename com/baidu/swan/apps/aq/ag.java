package com.baidu.swan.apps.aq;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes7.dex */
public class ag {
    public static boolean qE(String str) {
        return bM(com.baidu.swan.apps.swancore.b.qb(str));
    }

    public static boolean bM(long j) {
        SwanCoreVersion adQ = com.baidu.swan.apps.core.turbo.d.adw().adQ();
        long j2 = adQ != null ? adQ.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.i("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
