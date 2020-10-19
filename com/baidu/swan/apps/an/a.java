package com.baidu.swan.apps.an;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public final class a {
    private static String doH;

    public static String tu(String str) {
        return String.format("%s %s", str, aHB());
    }

    public static String aHB() {
        if (TextUtils.isEmpty(doH)) {
            doH = b.aHB();
        }
        return doH;
    }
}
