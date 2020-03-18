package com.baidu.swan.config.core;
/* loaded from: classes11.dex */
public class c {
    public static boolean ajd() {
        return (System.currentTimeMillis() - ajf()) / 1000 > aje();
    }

    public static void m(long j, long j2) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        b.ajc().edit().putLong("max_age", j).putLong("latest_update_time", j2).apply();
    }

    public static void aS(long j) {
        b.ajc().edit().putLong("latest_update_time", j).apply();
    }

    private static long aje() {
        return b.ajc().getLong("max_age", 0L);
    }

    private static long ajf() {
        return b.ajc().getLong("latest_update_time", 0L);
    }
}
