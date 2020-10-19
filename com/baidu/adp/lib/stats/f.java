package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class f {
    private static boolean NV;
    private static String NW;
    private static String NX;
    private static String NY;

    public static boolean nl() {
        return NV;
    }

    public static void aq(boolean z) {
        NV = z;
    }

    public static boolean a(com.baidu.adp.lib.stats.base.a aVar) {
        return (aVar instanceof com.baidu.adp.lib.stats.b.c) || (aVar instanceof com.baidu.adp.lib.stats.b.b) || (aVar instanceof com.baidu.adp.lib.stats.b.a);
    }

    public static String getClientIp() {
        return NW;
    }

    public static void bX(String str) {
        NW = str;
    }

    public static String nm() {
        return NX;
    }

    public static void bY(String str) {
        NX = str;
    }

    public static String nn() {
        return NY;
    }

    public static void bZ(String str) {
        NY = str;
    }
}
