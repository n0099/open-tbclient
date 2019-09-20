package com.baidu.swan.apps.v;
/* loaded from: classes2.dex */
public class a {
    private static String azv;

    public static void setInfo(String str) {
        azv = str;
    }

    public static String Fq() {
        return azv == null ? "" : azv;
    }

    public static void clean() {
        azv = null;
    }
}
