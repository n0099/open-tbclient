package com.baidu.swan.apps.am;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public final class a {
    private static String dQV;

    public static String uA(String str) {
        return String.format("%s %s", str, aQM());
    }

    public static String aQM() {
        if (TextUtils.isEmpty(dQV)) {
            dQV = b.aQM();
        }
        return dQV;
    }
}
