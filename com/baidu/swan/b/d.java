package com.baidu.swan.b;

import android.text.TextUtils;
/* loaded from: classes16.dex */
public class d {
    private static String elu = b.bdC().getString("openstat_switch", "1");

    public static boolean bdE() {
        return TextUtils.equals(elu, "1");
    }
}
