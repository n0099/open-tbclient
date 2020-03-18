package com.baidu.swan.apps.as;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes11.dex */
public class ad {
    public static boolean mP(String str) {
        return aL(com.baidu.swan.apps.swancore.b.mo(str));
    }

    public static boolean aL(long j) {
        SwanCoreVersion QT = com.baidu.swan.apps.core.k.d.Qz().QT();
        long j2 = QT != null ? QT.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.d("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
