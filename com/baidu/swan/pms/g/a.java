package com.baidu.swan.pms.g;

import com.baidu.swan.pms.utils.g;
/* loaded from: classes15.dex */
public class a {
    public static boolean mY(int i) {
        return (System.currentTimeMillis() - na(i)) / 1000 > mZ(i);
    }

    public static void k(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        g.bcF().edit().putLong("max_age" + i, j).apply();
    }

    public static void l(int i, long j) {
        g.bcF().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long mZ(int i) {
        return g.bcF().getLong("max_age" + i, 0L);
    }

    public static long na(int i) {
        return g.bcF().getLong("latest_update_time" + i, 0L);
    }
}
