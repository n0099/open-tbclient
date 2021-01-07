package com.baidu.swan.b;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class d {
    private static String eCg = b.bjf().getString("openstat_switch", "1");

    public static boolean bjh() {
        return TextUtils.equals(eCg, "1");
    }
}
