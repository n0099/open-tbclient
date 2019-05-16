package com.baidu.swan.apps.console.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class d {
    private static String anm;

    public static boolean xG() {
        return !TextUtils.isEmpty(anm);
    }

    public static String xH() {
        return anm + "/swan-core/master/master.html";
    }

    public static String xI() {
        return anm + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        anm = str;
    }
}
