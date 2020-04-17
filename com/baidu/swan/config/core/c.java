package com.baidu.swan.config.core;
/* loaded from: classes11.dex */
public class c {
    public static boolean arl() {
        return (System.currentTimeMillis() - arn()) / 1000 > arm();
    }

    public static void n(long j, long j2) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        b.ark().edit().putLong("max_age", j).putLong("latest_update_time", j2).apply();
    }

    public static void bx(long j) {
        b.ark().edit().putLong("latest_update_time", j).apply();
    }

    private static long arm() {
        return b.ark().getLong("max_age", 0L);
    }

    private static long arn() {
        return b.ark().getLong("latest_update_time", 0L);
    }
}
