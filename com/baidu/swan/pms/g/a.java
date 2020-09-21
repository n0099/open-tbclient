package com.baidu.swan.pms.g;

import com.baidu.swan.pms.utils.g;
/* loaded from: classes24.dex */
public class a {
    public static boolean mg(int i) {
        return (System.currentTimeMillis() - mi(i)) / 1000 > mh(i);
    }

    public static void k(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        g.aVD().edit().putLong("max_age" + i, j).apply();
    }

    public static void l(int i, long j) {
        g.aVD().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long mh(int i) {
        return g.aVD().getLong("max_age" + i, 0L);
    }

    public static long mi(int i) {
        return g.aVD().getLong("latest_update_time" + i, 0L);
    }
}
