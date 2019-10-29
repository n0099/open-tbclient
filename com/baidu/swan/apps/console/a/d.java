package com.baidu.swan.apps.console.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class d {
    private static String aHE;

    public static boolean Dk() {
        return !TextUtils.isEmpty(aHE);
    }

    public static String Dl() {
        return aHE + "/swan-core/master/master.html";
    }

    public static String Dm() {
        return aHE + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        aHE = str;
    }
}
