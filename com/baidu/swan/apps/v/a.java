package com.baidu.swan.apps.v;
/* loaded from: classes2.dex */
public class a {
    private static String ayq;

    public static void setInfo(String str) {
        ayq = str;
    }

    public static String getInfo() {
        return ayq == null ? "" : ayq;
    }

    public static void clean() {
        ayq = null;
    }
}
