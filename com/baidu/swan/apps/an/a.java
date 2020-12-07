package com.baidu.swan.apps.an;

import android.text.TextUtils;
/* loaded from: classes25.dex */
public final class a {
    private static String dIq;

    public static String uD(String str) {
        return String.format("%s %s", str, aOu());
    }

    public static String aOu() {
        if (TextUtils.isEmpty(dIq)) {
            dIq = b.aOu();
        }
        return dIq;
    }
}
