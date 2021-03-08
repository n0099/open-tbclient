package com.baidu.swan.apps.am;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public final class a {
    private static String dPO;

    public static String tP(String str) {
        return String.format("%s %s", str, aNo());
    }

    public static String aNo() {
        if (TextUtils.isEmpty(dPO)) {
            dPO = b.aNo();
        }
        return dPO;
    }
}
