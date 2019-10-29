package com.baidu.swan.apps.statistic;
/* loaded from: classes2.dex */
public final class d {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bpk = 0;

    public static String eJ(int i) {
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

    public static int Sx() {
        return bpk;
    }

    public static void eK(int i) {
        bpk = i;
    }
}
