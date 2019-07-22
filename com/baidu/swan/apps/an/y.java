package com.baidu.swan.apps.an;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes2.dex */
public class y {
    public static boolean io(String str) {
        return ac(com.baidu.swan.apps.swancore.b.hO(str));
    }

    public static boolean ac(long j) {
        SwanCoreVersion Ci = com.baidu.swan.apps.core.j.c.BQ().Ci();
        long j2 = Ci != null ? Ci.aWG : 0L;
        com.baidu.swan.apps.console.c.d("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
