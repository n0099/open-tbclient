package com.baidu.swan.apps.as;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes9.dex */
public class ad {
    public static boolean my(String str) {
        return aE(com.baidu.swan.apps.swancore.b.lX(str));
    }

    public static boolean aE(long j) {
        SwanCoreVersion Oe = com.baidu.swan.apps.core.k.d.NK().Oe();
        long j2 = Oe != null ? Oe.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.d("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
