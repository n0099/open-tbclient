package com.baidu.swan.b;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class d {
    private static String dKJ = b.aWw().getString("openstat_switch", "1");

    public static boolean aWy() {
        return TextUtils.equals(dKJ, "1");
    }
}
