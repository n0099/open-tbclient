package com.baidu.swan.pms.g;

import com.baidu.swan.pms.utils.g;
/* loaded from: classes6.dex */
public class a {
    public static boolean ns(int i) {
        return (System.currentTimeMillis() - nu(i)) / 1000 > nt(i);
    }

    public static void k(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        g.bfd().edit().putLong("max_age" + i, j).apply();
    }

    public static void l(int i, long j) {
        g.bfd().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long nt(int i) {
        return g.bfd().getLong("max_age" + i, 0L);
    }

    public static long nu(int i) {
        return g.bfd().getLong("latest_update_time" + i, 0L);
    }
}
