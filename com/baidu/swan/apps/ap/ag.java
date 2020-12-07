package com.baidu.swan.apps.ap;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes25.dex */
public class ag {
    public static boolean uU(String str) {
        return cX(com.baidu.swan.apps.swancore.b.ur(str));
    }

    public static boolean cX(long j) {
        SwanCoreVersion auD = com.baidu.swan.apps.core.turbo.d.aui().auD();
        long j2 = auD != null ? auD.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.i("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
