package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class f {
    private static boolean OR;
    private static String OT;
    private static String OU;
    private static String OV;

    public static boolean mO() {
        return OR;
    }

    public static void ao(boolean z) {
        OR = z;
    }

    public static boolean a(com.baidu.adp.lib.stats.base.a aVar) {
        return (aVar instanceof com.baidu.adp.lib.stats.c.c) || (aVar instanceof com.baidu.adp.lib.stats.c.b) || (aVar instanceof com.baidu.adp.lib.stats.c.a);
    }

    public static String getClientIp() {
        return OT;
    }

    public static void bU(String str) {
        OT = str;
    }

    public static String getActivityId() {
        return OU;
    }

    public static void setActivityId(String str) {
        OU = str;
    }

    public static String mP() {
        return OV;
    }

    public static void bV(String str) {
        OV = str;
    }
}
