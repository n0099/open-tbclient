package com.baidu.swan.b;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class d {
    private static String exr = b.bfl().getString("openstat_switch", "1");

    public static boolean bfn() {
        return TextUtils.equals(exr, "1");
    }
}
