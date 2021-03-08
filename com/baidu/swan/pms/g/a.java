package com.baidu.swan.pms.g;

import com.baidu.swan.pms.utils.g;
/* loaded from: classes3.dex */
public class a {
    public static boolean lZ(int i) {
        return (System.currentTimeMillis() - mb(i)) / 1000 > ma(i);
    }

    public static void l(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        g.bdU().edit().putLong("max_age" + i, j).apply();
    }

    public static void m(int i, long j) {
        g.bdU().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long ma(int i) {
        return g.bdU().getLong("max_age" + i, 0L);
    }

    public static long mb(int i) {
        return g.bdU().getLong("latest_update_time" + i, 0L);
    }
}
