package com.baidu.swan.apps.ao;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public final class a {
    private static String cNV;

    public static String pC(String str) {
        return String.format("%s %s", str, atY());
    }

    public static String atY() {
        if (TextUtils.isEmpty(cNV)) {
            cNV = b.atY();
        }
        return cNV;
    }
}
