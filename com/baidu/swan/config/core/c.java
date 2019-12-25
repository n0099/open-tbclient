package com.baidu.swan.config.core;
/* loaded from: classes9.dex */
public class c {
    public static boolean agr() {
        return (System.currentTimeMillis() - agt()) / 1000 > ags();
    }

    public static void m(long j, long j2) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        b.agq().edit().putLong("max_age", j).putLong("latest_update_time", j2).apply();
    }

    public static void aL(long j) {
        b.agq().edit().putLong("latest_update_time", j).apply();
    }

    private static long ags() {
        return b.agq().getLong("max_age", 0L);
    }

    private static long agt() {
        return b.agq().getLong("latest_update_time", 0L);
    }
}
