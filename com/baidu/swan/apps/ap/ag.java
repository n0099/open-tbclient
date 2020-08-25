package com.baidu.swan.apps.ap;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes8.dex */
public class ag {
    public static boolean sF(String str) {
        return bR(com.baidu.swan.apps.swancore.b.sb(str));
    }

    public static boolean bR(long j) {
        SwanCoreVersion akn = com.baidu.swan.apps.core.turbo.d.ajS().akn();
        long j2 = akn != null ? akn.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.i("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
