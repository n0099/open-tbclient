package com.baidu.swan.apps.an;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes2.dex */
public class y {
    public static boolean iq(String str) {
        return ac(com.baidu.swan.apps.swancore.b.hQ(str));
    }

    public static boolean ac(long j) {
        SwanCoreVersion Cm = com.baidu.swan.apps.core.j.c.BU().Cm();
        long j2 = Cm != null ? Cm.aXe : 0L;
        com.baidu.swan.apps.console.c.d("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
