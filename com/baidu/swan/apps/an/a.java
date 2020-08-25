package com.baidu.swan.apps.an;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public final class a {
    private static String dar;

    public static String sn(String str) {
        return String.format("%s %s", str, aEi());
    }

    public static String aEi() {
        if (TextUtils.isEmpty(dar)) {
            dar = b.aEi();
        }
        return dar;
    }
}
