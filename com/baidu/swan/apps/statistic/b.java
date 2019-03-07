package com.baidu.swan.apps.statistic;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static int aSd = 0;

    public static String dA(int i) {
        switch (i) {
            case -1:
                return "";
            case 0:
                return "swan";
            case 1:
                return "swangame";
            default:
                return "swan";
        }
    }

    public static int Kr() {
        return aSd;
    }

    public static void dB(int i) {
        aSd = i;
    }
}
