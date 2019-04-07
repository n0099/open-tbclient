package com.baidu.swan.apps.statistic;
/* loaded from: classes2.dex */
public final class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int aSh = 0;

    public static String dz(int i) {
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

    public static int Kp() {
        return aSh;
    }

    public static void dA(int i) {
        aSh = i;
    }
}
