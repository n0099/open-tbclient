package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class f {
    private static boolean NW;
    private static String NX;
    private static String NY;
    private static String NZ;

    public static boolean nl() {
        return NW;
    }

    public static void aq(boolean z) {
        NW = z;
    }

    public static boolean a(com.baidu.adp.lib.stats.base.a aVar) {
        return (aVar instanceof com.baidu.adp.lib.stats.b.c) || (aVar instanceof com.baidu.adp.lib.stats.b.b) || (aVar instanceof com.baidu.adp.lib.stats.b.a);
    }

    public static String getClientIp() {
        return NX;
    }

    public static void bX(String str) {
        NX = str;
    }

    public static String nm() {
        return NY;
    }

    public static void bY(String str) {
        NY = str;
    }

    public static String nn() {
        return NZ;
    }

    public static void bZ(String str) {
        NZ = str;
    }
}
