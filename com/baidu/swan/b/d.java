package com.baidu.swan.b;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class d {
    private static String enb = b.bej().getString("openstat_switch", "1");

    public static boolean bel() {
        return TextUtils.equals(enb, "1");
    }
}
