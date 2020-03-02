package com.baidu.swan.apps.as;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes11.dex */
public class ad {
    public static boolean mQ(String str) {
        return aL(com.baidu.swan.apps.swancore.b.mp(str));
    }

    public static boolean aL(long j) {
        SwanCoreVersion QQ = com.baidu.swan.apps.core.k.d.Qw().QQ();
        long j2 = QQ != null ? QQ.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.d("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
