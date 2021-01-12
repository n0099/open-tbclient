package com.baidu.swan.pms.g;

import com.baidu.swan.pms.utils.g;
/* loaded from: classes6.dex */
public class a {
    public static boolean lV(int i) {
        return (System.currentTimeMillis() - lX(i)) / 1000 > lW(i);
    }

    public static void k(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        g.bdF().edit().putLong("max_age" + i, j).apply();
    }

    public static void l(int i, long j) {
        g.bdF().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long lW(int i) {
        return g.bdF().getLong("max_age" + i, 0L);
    }

    public static long lX(int i) {
        return g.bdF().getLong("latest_update_time" + i, 0L);
    }
}
