package com.baidu.swan.apps.aq;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public final class a {
    private static String bYi;

    public static String mz(String str) {
        return String.format("%s %s", str, agt());
    }

    public static String agt() {
        if (TextUtils.isEmpty(bYi)) {
            bYi = b.agt();
        }
        return bYi;
    }
}
