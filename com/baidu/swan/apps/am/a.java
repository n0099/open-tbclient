package com.baidu.swan.apps.am;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public final class a {
    private static String dQV;

    public static String uA(String str) {
        return String.format("%s %s", str, aQL());
    }

    public static String aQL() {
        if (TextUtils.isEmpty(dQV)) {
            dQV = b.aQL();
        }
        return dQV;
    }
}
