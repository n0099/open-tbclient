package com.baidu.swan.apps.v;
/* loaded from: classes2.dex */
public class a {
    private static String axC;

    public static void setInfo(String str) {
        axC = str;
    }

    public static String getInfo() {
        return axC == null ? "" : axC;
    }

    public static void clean() {
        axC = null;
    }
}
