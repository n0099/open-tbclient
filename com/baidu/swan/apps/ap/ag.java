package com.baidu.swan.apps.ap;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes10.dex */
public class ag {
    public static boolean ue(String str) {
        return cc(com.baidu.swan.apps.swancore.b.tB(str));
    }

    public static boolean cc(long j) {
        SwanCoreVersion apD = com.baidu.swan.apps.core.turbo.d.aph().apD();
        long j2 = apD != null ? apD.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.i("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
