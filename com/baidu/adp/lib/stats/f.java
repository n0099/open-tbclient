package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class f {
    private static boolean OP;
    private static String OQ;
    private static String OR;
    private static String OT;

    public static boolean mN() {
        return OP;
    }

    public static void ao(boolean z) {
        OP = z;
    }

    public static boolean a(com.baidu.adp.lib.stats.base.a aVar) {
        return (aVar instanceof com.baidu.adp.lib.stats.c.c) || (aVar instanceof com.baidu.adp.lib.stats.c.b) || (aVar instanceof com.baidu.adp.lib.stats.c.a);
    }

    public static String getClientIp() {
        return OQ;
    }

    public static void bU(String str) {
        OQ = str;
    }

    public static String getActivityId() {
        return OR;
    }

    public static void setActivityId(String str) {
        OR = str;
    }

    public static String mO() {
        return OT;
    }

    public static void bV(String str) {
        OT = str;
    }
}
