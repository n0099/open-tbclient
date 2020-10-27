package com.baidu.swan.pms.g;

import com.baidu.swan.pms.utils.g;
/* loaded from: classes15.dex */
public class a {
    public static boolean mO(int i) {
        return (System.currentTimeMillis() - mQ(i)) / 1000 > mP(i);
    }

    public static void l(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        g.baf().edit().putLong("max_age" + i, j).apply();
    }

    public static void m(int i, long j) {
        g.baf().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long mP(int i) {
        return g.baf().getLong("max_age" + i, 0L);
    }

    public static long mQ(int i) {
        return g.baf().getLong("latest_update_time" + i, 0L);
    }
}
