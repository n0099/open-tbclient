package com.baidu.swan.apps.console.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class d {
    private static String aon;

    public static boolean yp() {
        return !TextUtils.isEmpty(aon);
    }

    public static String yq() {
        return aon + "/swan-core/master/master.html";
    }

    public static String yr() {
        return aon + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        aon = str;
    }
}
