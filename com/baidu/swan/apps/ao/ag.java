package com.baidu.swan.apps.ao;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes8.dex */
public class ag {
    public static boolean tI(String str) {
        return cY(com.baidu.swan.apps.swancore.b.td(str));
    }

    public static boolean cY(long j) {
        SwanCoreVersion asb = com.baidu.swan.apps.core.turbo.d.arG().asb();
        long j2 = asb != null ? asb.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.i("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
