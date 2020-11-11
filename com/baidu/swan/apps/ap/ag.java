package com.baidu.swan.apps.ap;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes10.dex */
public class ag {
    public static boolean us(String str) {
        return cy(com.baidu.swan.apps.swancore.b.tP(str));
    }

    public static boolean cy(long j) {
        SwanCoreVersion asd = com.baidu.swan.apps.core.turbo.d.arI().asd();
        long j2 = asd != null ? asd.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.i("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
