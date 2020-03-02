package com.baidu.swan.apps.aq;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public final class a {
    private static String bXW;

    public static String mA(String str) {
        return String.format("%s %s", str, agq());
    }

    public static String agq() {
        if (TextUtils.isEmpty(bXW)) {
            bXW = b.agq();
        }
        return bXW;
    }
}
