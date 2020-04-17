package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class f {
    private static boolean LO;
    private static String LQ;
    private static String LR;
    private static String LS;

    public static boolean lo() {
        return LO;
    }

    public static void am(boolean z) {
        LO = z;
    }

    public static boolean a(com.baidu.adp.lib.stats.base.a aVar) {
        return (aVar instanceof com.baidu.adp.lib.stats.b.c) || (aVar instanceof com.baidu.adp.lib.stats.b.b) || (aVar instanceof com.baidu.adp.lib.stats.b.a);
    }

    public static String getClientIp() {
        return LQ;
    }

    public static void bQ(String str) {
        LQ = str;
    }

    public static String lp() {
        return LR;
    }

    public static void bR(String str) {
        LR = str;
    }

    public static String lq() {
        return LS;
    }

    public static void bS(String str) {
        LS = str;
    }
}
