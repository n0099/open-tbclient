package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class f {
    private static boolean Me;
    private static String Mf;
    private static String Mg;
    private static String Mh;

    public static boolean lq() {
        return Me;
    }

    public static void ao(boolean z) {
        Me = z;
    }

    public static boolean a(com.baidu.adp.lib.stats.base.a aVar) {
        return (aVar instanceof com.baidu.adp.lib.stats.b.c) || (aVar instanceof com.baidu.adp.lib.stats.b.b) || (aVar instanceof com.baidu.adp.lib.stats.b.a);
    }

    public static String getClientIp() {
        return Mf;
    }

    public static void bR(String str) {
        Mf = str;
    }

    public static String lr() {
        return Mg;
    }

    public static void bS(String str) {
        Mg = str;
    }

    public static String ls() {
        return Mh;
    }

    public static void bT(String str) {
        Mh = str;
    }
}
