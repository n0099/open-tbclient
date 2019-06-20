package com.baidu.swan.apps.al;

import android.text.TextUtils;
import com.baidu.swan.apps.c;
/* loaded from: classes2.dex */
public final class a {
    private static String aYZ;

    public static String hZ(String str) {
        return String.format("%s %s", str, Om());
    }

    public static String Om() {
        if (TextUtils.isEmpty(aYZ)) {
            aYZ = c.vv();
        }
        return aYZ;
    }
}
