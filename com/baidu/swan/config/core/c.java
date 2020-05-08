package com.baidu.swan.config.core;
/* loaded from: classes11.dex */
public class c {
    public static boolean ark() {
        return (System.currentTimeMillis() - arm()) / 1000 > arl();
    }

    public static void n(long j, long j2) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        b.arj().edit().putLong("max_age", j).putLong("latest_update_time", j2).apply();
    }

    public static void bx(long j) {
        b.arj().edit().putLong("latest_update_time", j).apply();
    }

    private static long arl() {
        return b.arj().getLong("max_age", 0L);
    }

    private static long arm() {
        return b.arj().getLong("latest_update_time", 0L);
    }
}
