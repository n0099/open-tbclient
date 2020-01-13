package com.baidu.swan.config.core;
/* loaded from: classes10.dex */
public class c {
    public static boolean agK() {
        return (System.currentTimeMillis() - agM()) / 1000 > agL();
    }

    public static void m(long j, long j2) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        b.agJ().edit().putLong("max_age", j).putLong("latest_update_time", j2).apply();
    }

    public static void aO(long j) {
        b.agJ().edit().putLong("latest_update_time", j).apply();
    }

    private static long agL() {
        return b.agJ().getLong("max_age", 0L);
    }

    private static long agM() {
        return b.agJ().getLong("latest_update_time", 0L);
    }
}
