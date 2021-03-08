package com.baidu.swan.b;

import android.text.TextUtils;
/* loaded from: classes14.dex */
public class d {
    private static String eBb = b.bfA().getString("openstat_switch", "1");

    public static boolean bfC() {
        return TextUtils.equals(eBb, "1");
    }
}
