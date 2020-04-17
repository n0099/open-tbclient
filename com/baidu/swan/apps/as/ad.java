package com.baidu.swan.apps.as;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes11.dex */
public class ad {
    public static boolean oc(String str) {
        return bq(com.baidu.swan.apps.swancore.b.nB(str));
    }

    public static boolean bq(long j) {
        SwanCoreVersion YI = com.baidu.swan.apps.core.k.d.Yo().YI();
        long j2 = YI != null ? YI.swanCoreVersion : 0L;
        com.baidu.swan.apps.console.c.d("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
