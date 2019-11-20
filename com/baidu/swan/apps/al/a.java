package com.baidu.swan.apps.al;

import android.text.TextUtils;
import com.baidu.swan.apps.c;
/* loaded from: classes2.dex */
public final class a {
    private static String bsp;

    public static String iM(String str) {
        return String.format("%s %s", str, TT());
    }

    public static String TT() {
        if (TextUtils.isEmpty(bsp)) {
            bsp = c.AV();
        }
        return bsp;
    }
}
