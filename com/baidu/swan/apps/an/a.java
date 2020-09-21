package com.baidu.swan.apps.an;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class a {
    private static String dcy;

    public static String sI(String str) {
        return String.format("%s %s", str, aES());
    }

    public static String aES() {
        if (TextUtils.isEmpty(dcy)) {
            dcy = b.aES();
        }
        return dcy;
    }
}
