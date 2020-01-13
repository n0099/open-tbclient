package com.baidu.swan.apps.aq;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public final class a {
    private static String bTR;

    public static String ml(String str) {
        return String.format("%s %s", str, aea());
    }

    public static String aea() {
        if (TextUtils.isEmpty(bTR)) {
            bTR = b.aea();
        }
        return bTR;
    }
}
