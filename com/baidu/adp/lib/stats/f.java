package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class f {
    private static boolean LU;
    private static String LV;
    private static String LW;
    private static String LX;

    public static boolean lo() {
        return LU;
    }

    public static void am(boolean z) {
        LU = z;
    }

    public static boolean a(com.baidu.adp.lib.stats.base.a aVar) {
        return (aVar instanceof com.baidu.adp.lib.stats.b.c) || (aVar instanceof com.baidu.adp.lib.stats.b.b) || (aVar instanceof com.baidu.adp.lib.stats.b.a);
    }

    public static String getClientIp() {
        return LV;
    }

    public static void bQ(String str) {
        LV = str;
    }

    public static String lp() {
        return LW;
    }

    public static void bR(String str) {
        LW = str;
    }

    public static String lq() {
        return LX;
    }

    public static void bS(String str) {
        LX = str;
    }
}
