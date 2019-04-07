package com.baidu.swan.apps.console.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class d {
    private static String amZ;

    public static boolean wO() {
        return !TextUtils.isEmpty(amZ);
    }

    public static String wP() {
        return amZ + "/swan-core/master/master.html";
    }

    public static String wQ() {
        return amZ + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        amZ = str;
    }
}
