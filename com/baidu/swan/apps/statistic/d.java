package com.baidu.swan.apps.statistic;
/* loaded from: classes2.dex */
public final class d {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int aVI = 0;

    public static String dN(int i) {
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

    public static int ND() {
        return aVI;
    }

    public static void dO(int i) {
        aVI = i;
    }
}
