package com.baidu.swan.apps.console.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class d {
    private static String amU;

    public static boolean wP() {
        return !TextUtils.isEmpty(amU);
    }

    public static String wQ() {
        return amU + "/swan-core/master/master.html";
    }

    public static String wR() {
        return amU + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        amU = str;
    }
}
