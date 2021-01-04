package com.baidu.swan.pms.g;

import com.baidu.swan.pms.utils.g;
/* loaded from: classes6.dex */
public class a {
    public static boolean nB(int i) {
        return (System.currentTimeMillis() - nD(i)) / 1000 > nC(i);
    }

    public static void k(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        g.bhy().edit().putLong("max_age" + i, j).apply();
    }

    public static void l(int i, long j) {
        g.bhy().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long nC(int i) {
        return g.bhy().getLong("max_age" + i, 0L);
    }

    public static long nD(int i) {
        return g.bhy().getLong("latest_update_time" + i, 0L);
    }
}
