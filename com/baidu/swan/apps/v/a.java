package com.baidu.swan.apps.v;
/* loaded from: classes2.dex */
public class a {
    private static String ayX;

    public static void setInfo(String str) {
        ayX = str;
    }

    public static String Fm() {
        return ayX == null ? "" : ayX;
    }

    public static void clean() {
        ayX = null;
    }
}
