package com.baidu.swan.apps.aq;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public final class a {
    private static String bXX;

    public static String mA(String str) {
        return String.format("%s %s", str, agq());
    }

    public static String agq() {
        if (TextUtils.isEmpty(bXX)) {
            bXX = b.agq();
        }
        return bXX;
    }
}
