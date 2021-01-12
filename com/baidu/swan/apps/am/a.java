package com.baidu.swan.apps.am;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public final class a {
    private static String dMj;

    public static String tp(String str) {
        return String.format("%s %s", str, aMS());
    }

    public static String aMS() {
        if (TextUtils.isEmpty(dMj)) {
            dMj = b.aMS();
        }
        return dMj;
    }
}
