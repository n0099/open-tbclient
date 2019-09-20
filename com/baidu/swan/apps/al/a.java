package com.baidu.swan.apps.al;

import android.text.TextUtils;
import com.baidu.swan.apps.c;
/* loaded from: classes2.dex */
public final class a {
    private static String bah;

    public static String ij(String str) {
        return String.format("%s %s", str, Pf());
    }

    public static String Pf() {
        if (TextUtils.isEmpty(bah)) {
            bah = c.wa();
        }
        return bah;
    }
}
