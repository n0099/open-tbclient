package com.baidu.swan.b;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class d {
    private static String dYN = b.aZQ().getString("openstat_switch", "1");

    public static boolean aZS() {
        return TextUtils.equals(dYN, "1");
    }
}
