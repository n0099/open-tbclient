package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class f {
    private static boolean sU;
    private static String sV;
    private static String sW;
    private static String sX;

    public static boolean gK() {
        return sU;
    }

    public static void N(boolean z) {
        sU = z;
    }

    public static boolean a(com.baidu.adp.lib.stats.base.a aVar) {
        return (aVar instanceof com.baidu.adp.lib.stats.b.c) || (aVar instanceof com.baidu.adp.lib.stats.b.b) || (aVar instanceof com.baidu.adp.lib.stats.b.a);
    }

    public static String getClientIp() {
        return sV;
    }

    public static void aB(String str) {
        sV = str;
    }

    public static String gL() {
        return sW;
    }

    public static void aC(String str) {
        sW = str;
    }

    public static String gM() {
        return sX;
    }

    public static void aD(String str) {
        sX = str;
    }
}
