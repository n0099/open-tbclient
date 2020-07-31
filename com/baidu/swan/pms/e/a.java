package com.baidu.swan.pms.e;

import com.baidu.swan.pms.f.g;
/* loaded from: classes19.dex */
public class a {
    public static boolean jP(int i) {
        return (System.currentTimeMillis() - jR(i)) / 1000 > jQ(i);
    }

    public static void k(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        g.aMr().edit().putLong("max_age" + i, j).apply();
    }

    public static void l(int i, long j) {
        g.aMr().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long jQ(int i) {
        return g.aMr().getLong("max_age" + i, 0L);
    }

    private static long jR(int i) {
        return g.aMr().getLong("latest_update_time" + i, 0L);
    }
}
