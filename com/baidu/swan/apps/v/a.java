package com.baidu.swan.apps.v;
/* loaded from: classes2.dex */
public class a {
    private static String aSJ;

    public static void setInfo(String str) {
        aSJ = str;
    }

    public static String Kk() {
        return aSJ == null ? "" : aSJ;
    }

    public static void clean() {
        aSJ = null;
    }
}
