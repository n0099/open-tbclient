package com.baidu.swan.apps.an;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes2.dex */
public class w {
    public static boolean hF(String str) {
        return O(com.baidu.swan.apps.swancore.b.hh(str));
    }

    public static boolean O(long j) {
        SwanCoreVersion Ar = com.baidu.swan.apps.core.i.c.Aa().Ar();
        long j2 = Ar != null ? Ar.aTh : 0L;
        com.baidu.swan.apps.console.c.d("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
