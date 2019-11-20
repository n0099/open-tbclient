package com.baidu.swan.apps.an;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes2.dex */
public class y {
    public static boolean iT(String str) {
        return au(com.baidu.swan.apps.swancore.b.iu(str));
    }

    public static boolean au(long j) {
        SwanCoreVersion Hh = com.baidu.swan.apps.core.j.c.GP().Hh();
        long j2 = Hh != null ? Hh.bpQ : 0L;
        com.baidu.swan.apps.console.c.d("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
