package com.baidu.swan.d;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class d {
    private static String dqS = b.aIZ().getString("openstat_switch", "1");

    public static boolean aJb() {
        return TextUtils.equals(dqS, "1");
    }
}
