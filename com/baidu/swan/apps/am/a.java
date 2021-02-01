package com.baidu.swan.apps.am;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public final class a {
    private static String dOn;

    public static String tI(String str) {
        return String.format("%s %s", str, aNl());
    }

    public static String aNl() {
        if (TextUtils.isEmpty(dOn)) {
            dOn = b.aNl();
        }
        return dOn;
    }
}
