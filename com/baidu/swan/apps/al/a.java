package com.baidu.swan.apps.al;

import android.text.TextUtils;
import com.baidu.swan.apps.c;
/* loaded from: classes2.dex */
public final class a {
    private static String aVV;

    public static String hx(String str) {
        return String.format("%s %s", str, LI());
    }

    public static String LI() {
        if (TextUtils.isEmpty(aVV)) {
            aVV = c.uM();
        }
        return aVV;
    }
}
