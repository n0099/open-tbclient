package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class f {
    private static boolean MG;
    private static String MH;
    private static String MI;
    private static String MJ;

    public static boolean lG() {
        return MG;
    }

    public static void ap(boolean z) {
        MG = z;
    }

    public static boolean a(com.baidu.adp.lib.stats.base.a aVar) {
        return (aVar instanceof com.baidu.adp.lib.stats.b.c) || (aVar instanceof com.baidu.adp.lib.stats.b.b) || (aVar instanceof com.baidu.adp.lib.stats.b.a);
    }

    public static String getClientIp() {
        return MH;
    }

    public static void bS(String str) {
        MH = str;
    }

    public static String lH() {
        return MI;
    }

    public static void bT(String str) {
        MI = str;
    }

    public static String lI() {
        return MJ;
    }

    public static void bU(String str) {
        MJ = str;
    }
}
