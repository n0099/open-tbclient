package com.baidu.swan.c;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class d {
    private static String dBu = b.aNW().getString("openstat_switch", "1");

    public static boolean aNY() {
        return TextUtils.equals(dBu, "1");
    }
}
