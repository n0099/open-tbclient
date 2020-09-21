package com.baidu.swan.b;

import android.text.TextUtils;
/* loaded from: classes14.dex */
public class d {
    private static String dMM = b.aXi().getString("openstat_switch", "1");

    public static boolean aXk() {
        return TextUtils.equals(dMM, "1");
    }
}
