package com.baidu.swan.apps.an;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public final class a {
    private static String dCZ;

    public static String ub(String str) {
        return String.format("%s %s", str, aLV());
    }

    public static String aLV() {
        if (TextUtils.isEmpty(dCZ)) {
            dCZ = b.aLV();
        }
        return dCZ;
    }
}
