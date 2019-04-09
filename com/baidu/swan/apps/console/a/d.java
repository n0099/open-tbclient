package com.baidu.swan.apps.console.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class d {
    private static String ana;

    public static boolean wO() {
        return !TextUtils.isEmpty(ana);
    }

    public static String wP() {
        return ana + "/swan-core/master/master.html";
    }

    public static String wQ() {
        return ana + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        ana = str;
    }
}
