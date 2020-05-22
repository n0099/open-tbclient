package com.baidu.swan.apps.ao;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public final class a {
    private static String cJl;

    public static String pu(String str) {
        return String.format("%s %s", str, asS());
    }

    public static String asS() {
        if (TextUtils.isEmpty(cJl)) {
            cJl = b.asS();
        }
        return cJl;
    }
}
