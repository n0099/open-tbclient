package com.baidu.swan.pms.g;

import com.baidu.swan.pms.utils.g;
/* loaded from: classes3.dex */
public class a {
    public static boolean lY(int i) {
        return (System.currentTimeMillis() - ma(i)) / 1000 > lZ(i);
    }

    public static void l(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        g.bdS().edit().putLong("max_age" + i, j).apply();
    }

    public static void m(int i, long j) {
        g.bdS().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long lZ(int i) {
        return g.bdS().getLong("max_age" + i, 0L);
    }

    public static long ma(int i) {
        return g.bdS().getLong("latest_update_time" + i, 0L);
    }
}
