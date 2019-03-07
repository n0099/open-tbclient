package com.baidu.swan.apps.v;
/* loaded from: classes2.dex */
public class a {
    private static String axx;

    public static void setInfo(String str) {
        axx = str;
    }

    public static String getInfo() {
        return axx == null ? "" : axx;
    }

    public static void clean() {
        axx = null;
    }
}
