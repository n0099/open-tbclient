package com.baidu.swan.apps.ap;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes3.dex */
public class ag {
    public static boolean sZ(String str) {
        return bS(com.baidu.swan.apps.swancore.b.sw(str));
    }

    public static boolean bS(long j) {
        SwanCoreVersion akX = com.baidu.swan.apps.core.turbo.d.akC().akX();
        long j2 = akX != null ? akX.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.i("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
