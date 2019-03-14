package com.baidu.swan.apps.console.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class d {
    private static String amV;

    public static boolean wP() {
        return !TextUtils.isEmpty(amV);
    }

    public static String wQ() {
        return amV + "/swan-core/master/master.html";
    }

    public static String wR() {
        return amV + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        amV = str;
    }
}
