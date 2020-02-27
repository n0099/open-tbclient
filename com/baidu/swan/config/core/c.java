package com.baidu.swan.config.core;
/* loaded from: classes11.dex */
public class c {
    public static boolean aiY() {
        return (System.currentTimeMillis() - aja()) / 1000 > aiZ();
    }

    public static void m(long j, long j2) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        b.aiX().edit().putLong("max_age", j).putLong("latest_update_time", j2).apply();
    }

    public static void aS(long j) {
        b.aiX().edit().putLong("latest_update_time", j).apply();
    }

    private static long aiZ() {
        return b.aiX().getLong("max_age", 0L);
    }

    private static long aja() {
        return b.aiX().getLong("latest_update_time", 0L);
    }
}
