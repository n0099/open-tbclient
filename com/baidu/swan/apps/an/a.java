package com.baidu.swan.apps.an;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public final class a {
    private static String dxh;

    public static String tN(String str) {
        return String.format("%s %s", str, aJv());
    }

    public static String aJv() {
        if (TextUtils.isEmpty(dxh)) {
            dxh = b.aJv();
        }
        return dxh;
    }
}
