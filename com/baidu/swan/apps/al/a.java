package com.baidu.swan.apps.al;

import android.text.TextUtils;
import com.baidu.swan.apps.c;
/* loaded from: classes2.dex */
public final class a {
    private static String btg;

    public static String iM(String str) {
        return String.format("%s %s", str, TV());
    }

    public static String TV() {
        if (TextUtils.isEmpty(btg)) {
            btg = c.AU();
        }
        return btg;
    }
}
