package com.baidu.swan.b;

import android.text.TextUtils;
/* loaded from: classes15.dex */
public class d {
    private static String ezA = b.bfy().getString("openstat_switch", "1");

    public static boolean bfA() {
        return TextUtils.equals(ezA, "1");
    }
}
