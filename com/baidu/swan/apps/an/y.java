package com.baidu.swan.apps.an;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes2.dex */
public class y {
    public static boolean iT(String str) {
        return av(com.baidu.swan.apps.swancore.b.iu(str));
    }

    public static boolean av(long j) {
        SwanCoreVersion Hg = com.baidu.swan.apps.core.j.c.GO().Hg();
        long j2 = Hg != null ? Hg.bqi : 0L;
        com.baidu.swan.apps.console.c.d("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
