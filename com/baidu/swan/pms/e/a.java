package com.baidu.swan.pms.e;

import com.baidu.swan.pms.f.f;
/* loaded from: classes11.dex */
public class a {
    public static boolean jj(int i) {
        return (System.currentTimeMillis() - jl(i)) / 1000 > jk(i);
    }

    public static void j(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        f.aHt().edit().putLong("max_age" + i, j).apply();
    }

    public static void k(int i, long j) {
        f.aHt().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long jk(int i) {
        return f.aHt().getLong("max_age" + i, 0L);
    }

    private static long jl(int i) {
        return f.aHt().getLong("latest_update_time" + i, 0L);
    }
}
