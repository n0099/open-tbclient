package com.baidu.swan.apps.console.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class d {
    private static String aHm;

    public static boolean Dl() {
        return !TextUtils.isEmpty(aHm);
    }

    public static String Dm() {
        return aHm + "/swan-core/master/master.html";
    }

    public static String Dn() {
        return aHm + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        aHm = str;
    }
}
