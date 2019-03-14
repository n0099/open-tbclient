package com.baidu.swan.apps.an;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes2.dex */
public class w {
    public static boolean hE(String str) {
        return O(com.baidu.swan.apps.swancore.b.hg(str));
    }

    public static boolean O(long j) {
        SwanCoreVersion As = com.baidu.swan.apps.core.i.c.Ab().As();
        long j2 = As != null ? As.aTd : 0L;
        com.baidu.swan.apps.console.c.d("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }
}
