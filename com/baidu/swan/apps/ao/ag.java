package com.baidu.swan.apps.ao;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes9.dex */
public class ag {
    public static boolean ub(String str) {
        return de(com.baidu.swan.apps.swancore.b.tw(str));
    }

    public static boolean de(long j) {
        SwanCoreVersion asA = com.baidu.swan.apps.core.turbo.d.ase().asA();
        long j2 = asA != null ? asA.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.i("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
