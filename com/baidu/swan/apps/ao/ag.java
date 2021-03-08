package com.baidu.swan.apps.ao;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes8.dex */
public class ag {
    public static boolean ui(String str) {
        return de(com.baidu.swan.apps.swancore.b.tD(str));
    }

    public static boolean de(long j) {
        SwanCoreVersion asD = com.baidu.swan.apps.core.turbo.d.ash().asD();
        long j2 = asD != null ? asD.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.i("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
