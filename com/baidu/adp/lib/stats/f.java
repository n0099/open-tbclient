package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class f {
    private static boolean MF;
    private static String MG;
    private static String MH;
    private static String MI;

    public static boolean lG() {
        return MF;
    }

    public static void ap(boolean z) {
        MF = z;
    }

    public static boolean a(com.baidu.adp.lib.stats.base.a aVar) {
        return (aVar instanceof com.baidu.adp.lib.stats.b.c) || (aVar instanceof com.baidu.adp.lib.stats.b.b) || (aVar instanceof com.baidu.adp.lib.stats.b.a);
    }

    public static String getClientIp() {
        return MG;
    }

    public static void bQ(String str) {
        MG = str;
    }

    public static String lH() {
        return MH;
    }

    public static void bR(String str) {
        MH = str;
    }

    public static String lI() {
        return MI;
    }

    public static void bS(String str) {
        MI = str;
    }
}
