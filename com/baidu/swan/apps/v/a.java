package com.baidu.swan.apps.v;
/* loaded from: classes2.dex */
public class a {
    private static String axB;

    public static void setInfo(String str) {
        axB = str;
    }

    public static String getInfo() {
        return axB == null ? "" : axB;
    }

    public static void clean() {
        axB = null;
    }
}
