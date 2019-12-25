package com.baidu.swan.apps.aq;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public final class a {
    private static String bTF;

    public static String mi(String str) {
        return String.format("%s %s", str, adH());
    }

    public static String adH() {
        if (TextUtils.isEmpty(bTF)) {
            bTF = b.adH();
        }
        return bTF;
    }
}
