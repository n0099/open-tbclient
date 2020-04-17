package com.baidu.swan.apps.aq;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public final class a {
    private static String cxa;

    public static String nM(String str) {
        return String.format("%s %s", str, aoy());
    }

    public static String aoy() {
        if (TextUtils.isEmpty(cxa)) {
            cxa = b.aoy();
        }
        return cxa;
    }
}
