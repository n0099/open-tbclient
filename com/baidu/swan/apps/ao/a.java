package com.baidu.swan.apps.ao;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class a {
    private static String cRr;

    public static String qn(String str) {
        return String.format("%s %s", str, avZ());
    }

    public static String avZ() {
        if (TextUtils.isEmpty(cRr)) {
            cRr = b.avZ();
        }
        return cRr;
    }
}
