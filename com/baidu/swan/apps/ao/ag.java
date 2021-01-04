package com.baidu.swan.apps.ao;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes9.dex */
public class ag {
    public static boolean uT(String str) {
        return cY(com.baidu.swan.apps.swancore.b.uo(str));
    }

    public static boolean cY(long j) {
        SwanCoreVersion avV = com.baidu.swan.apps.core.turbo.d.avA().avV();
        long j2 = avV != null ? avV.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.i("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
