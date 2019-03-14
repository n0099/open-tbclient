package com.baidu.swan.apps.v;
/* loaded from: classes2.dex */
public class a {
    private static String axy;

    public static void setInfo(String str) {
        axy = str;
    }

    public static String getInfo() {
        return axy == null ? "" : axy;
    }

    public static void clean() {
        axy = null;
    }
}
