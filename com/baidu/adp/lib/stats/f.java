package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class f {
    private static boolean OU;
    private static String OV;
    private static String OW;
    private static String OX;

    public static boolean mO() {
        return OU;
    }

    public static void ao(boolean z) {
        OU = z;
    }

    public static boolean a(com.baidu.adp.lib.stats.base.a aVar) {
        return (aVar instanceof com.baidu.adp.lib.stats.c.c) || (aVar instanceof com.baidu.adp.lib.stats.c.b) || (aVar instanceof com.baidu.adp.lib.stats.c.a);
    }

    public static String getClientIp() {
        return OV;
    }

    public static void bU(String str) {
        OV = str;
    }

    public static String getActivityId() {
        return OW;
    }

    public static void setActivityId(String str) {
        OW = str;
    }

    public static String mP() {
        return OX;
    }

    public static void bV(String str) {
        OX = str;
    }
}
