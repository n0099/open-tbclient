package com.baidu.swan.b;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class d {
    private static String ehk = b.bbJ().getString("openstat_switch", "1");

    public static boolean bbL() {
        return TextUtils.equals(ehk, "1");
    }
}
