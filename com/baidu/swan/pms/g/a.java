package com.baidu.swan.pms.g;

import com.baidu.swan.pms.utils.g;
/* loaded from: classes15.dex */
public class a {
    public static boolean mD(int i) {
        return (System.currentTimeMillis() - mF(i)) / 1000 > mE(i);
    }

    public static void l(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        g.aYm().edit().putLong("max_age" + i, j).apply();
    }

    public static void m(int i, long j) {
        g.aYm().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long mE(int i) {
        return g.aYm().getLong("max_age" + i, 0L);
    }

    public static long mF(int i) {
        return g.aYm().getLong("latest_update_time" + i, 0L);
    }
}
