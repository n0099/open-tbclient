package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class f {
    private static boolean OQ;
    private static String OR;
    private static String OT;
    private static String OU;

    public static boolean nl() {
        return OQ;
    }

    public static void ap(boolean z) {
        OQ = z;
    }

    public static boolean a(com.baidu.adp.lib.stats.base.a aVar) {
        return (aVar instanceof com.baidu.adp.lib.stats.c.c) || (aVar instanceof com.baidu.adp.lib.stats.c.b) || (aVar instanceof com.baidu.adp.lib.stats.c.a);
    }

    public static String getClientIp() {
        return OR;
    }

    public static void ca(String str) {
        OR = str;
    }

    public static String nm() {
        return OT;
    }

    public static void cb(String str) {
        OT = str;
    }

    public static String nn() {
        return OU;
    }

    public static void cc(String str) {
        OU = str;
    }
}
