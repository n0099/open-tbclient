package com.baidu.swan.apps.an;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class a {
    private static String dBs;

    public static String tW(String str) {
        return String.format("%s %s", str, aLn());
    }

    public static String aLn() {
        if (TextUtils.isEmpty(dBs)) {
            dBs = b.aLn();
        }
        return dBs;
    }
}
