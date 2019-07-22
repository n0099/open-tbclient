package com.baidu.swan.apps.al;

import android.text.TextUtils;
import com.baidu.swan.apps.c;
/* loaded from: classes2.dex */
public final class a {
    private static String aZJ;

    public static String ih(String str) {
        return String.format("%s %s", str, Pb());
    }

    public static String Pb() {
        if (TextUtils.isEmpty(aZJ)) {
            aZJ = c.vW();
        }
        return aZJ;
    }
}
