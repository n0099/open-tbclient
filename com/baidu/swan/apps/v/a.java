package com.baidu.swan.apps.v;
/* loaded from: classes2.dex */
public class a {
    private static String aSr;

    public static void setInfo(String str) {
        aSr = str;
    }

    public static String Kl() {
        return aSr == null ? "" : aSr;
    }

    public static void clean() {
        aSr = null;
    }
}
