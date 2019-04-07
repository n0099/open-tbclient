package com.baidu.swan.apps.al;

import android.text.TextUtils;
import com.baidu.swan.apps.c;
/* loaded from: classes2.dex */
public final class a {
    private static String aVY;

    public static String hy(String str) {
        return String.format("%s %s", str, LG());
    }

    public static String LG() {
        if (TextUtils.isEmpty(aVY)) {
            aVY = c.uL();
        }
        return aVY;
    }
}
