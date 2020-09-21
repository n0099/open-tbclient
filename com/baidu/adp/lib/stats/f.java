package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class f {
    private static boolean NC;
    private static String ND;
    private static String NF;
    private static String NG;

    public static boolean nk() {
        return NC;
    }

    public static void aq(boolean z) {
        NC = z;
    }

    public static boolean a(com.baidu.adp.lib.stats.base.a aVar) {
        return (aVar instanceof com.baidu.adp.lib.stats.b.c) || (aVar instanceof com.baidu.adp.lib.stats.b.b) || (aVar instanceof com.baidu.adp.lib.stats.b.a);
    }

    public static String getClientIp() {
        return ND;
    }

    public static void bX(String str) {
        ND = str;
    }

    public static String nl() {
        return NF;
    }

    public static void bY(String str) {
        NF = str;
    }

    public static String nm() {
        return NG;
    }

    public static void bZ(String str) {
        NG = str;
    }
}
