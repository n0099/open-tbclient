package com.baidu.swan.b;

import android.text.TextUtils;
/* loaded from: classes17.dex */
public class d {
    private static String esw = b.bgH().getString("openstat_switch", "1");

    public static boolean bgJ() {
        return TextUtils.equals(esw, "1");
    }
}
