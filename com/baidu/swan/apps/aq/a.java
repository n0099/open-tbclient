package com.baidu.swan.apps.aq;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public final class a {
    private static String bXV;

    public static String mA(String str) {
        return String.format("%s %s", str, ago());
    }

    public static String ago() {
        if (TextUtils.isEmpty(bXV)) {
            bXV = b.ago();
        }
        return bXV;
    }
}
