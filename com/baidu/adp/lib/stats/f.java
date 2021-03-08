package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class f {
    private static boolean Qp;
    private static String Qq;
    private static String Qr;
    private static String Qs;

    public static boolean mN() {
        return Qp;
    }

    public static void ao(boolean z) {
        Qp = z;
    }

    public static boolean a(com.baidu.adp.lib.stats.base.a aVar) {
        return (aVar instanceof com.baidu.adp.lib.stats.c.c) || (aVar instanceof com.baidu.adp.lib.stats.c.b) || (aVar instanceof com.baidu.adp.lib.stats.c.a);
    }

    public static String getClientIp() {
        return Qq;
    }

    public static void bY(String str) {
        Qq = str;
    }

    public static String getActivityId() {
        return Qr;
    }

    public static void setActivityId(String str) {
        Qr = str;
    }

    public static String mO() {
        return Qs;
    }

    public static void bZ(String str) {
        Qs = str;
    }
}
