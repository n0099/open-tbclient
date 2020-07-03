package com.baidu.swan.pms.e;

import com.baidu.swan.pms.f.f;
/* loaded from: classes11.dex */
public class a {
    public static boolean jw(int i) {
        return (System.currentTimeMillis() - jy(i)) / 1000 > jx(i);
    }

    public static void k(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        f.aIz().edit().putLong("max_age" + i, j).apply();
    }

    public static void l(int i, long j) {
        f.aIz().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long jx(int i) {
        return f.aIz().getLong("max_age" + i, 0L);
    }

    private static long jy(int i) {
        return f.aIz().getLong("latest_update_time" + i, 0L);
    }
}
