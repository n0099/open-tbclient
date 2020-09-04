package com.baidu.swan.apps.an;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public final class a {
    private static String daw;

    public static String so(String str) {
        return String.format("%s %s", str, aEi());
    }

    public static String aEi() {
        if (TextUtils.isEmpty(daw)) {
            daw = b.aEi();
        }
        return daw;
    }
}
