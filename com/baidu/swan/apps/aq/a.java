package com.baidu.swan.apps.aq;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public final class a {
    private static String cxg;

    public static String nM(String str) {
        return String.format("%s %s", str, aox());
    }

    public static String aox() {
        if (TextUtils.isEmpty(cxg)) {
            cxg = b.aox();
        }
        return cxg;
    }
}
