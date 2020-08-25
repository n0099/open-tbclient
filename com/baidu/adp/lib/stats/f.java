package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class f {
    private static boolean Nk;
    private static String Nl;
    private static String Nm;
    private static String Nn;

    public static boolean nf() {
        return Nk;
    }

    public static void aq(boolean z) {
        Nk = z;
    }

    public static boolean a(com.baidu.adp.lib.stats.base.a aVar) {
        return (aVar instanceof com.baidu.adp.lib.stats.b.c) || (aVar instanceof com.baidu.adp.lib.stats.b.b) || (aVar instanceof com.baidu.adp.lib.stats.b.a);
    }

    public static String getClientIp() {
        return Nl;
    }

    public static void bV(String str) {
        Nl = str;
    }

    public static String ng() {
        return Nm;
    }

    public static void bW(String str) {
        Nm = str;
    }

    public static String nh() {
        return Nn;
    }

    public static void bX(String str) {
        Nn = str;
    }
}
