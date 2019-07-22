package com.baidu.swan.apps.console.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class d {
    private static String anP;

    public static boolean yl() {
        return !TextUtils.isEmpty(anP);
    }

    public static String ym() {
        return anP + "/swan-core/master/master.html";
    }

    public static String yn() {
        return anP + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        anP = str;
    }
}
