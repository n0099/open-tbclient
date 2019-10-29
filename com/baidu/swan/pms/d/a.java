package com.baidu.swan.pms.d;

import com.baidu.swan.pms.e.f;
/* loaded from: classes2.dex */
public class a {
    public static boolean gJ(int i) {
        return (System.currentTimeMillis() - gL(i)) / 1000 > gK(i);
    }

    public static void f(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        f.abT().edit().putLong("max_age" + i, j).apply();
    }

    public static void g(int i, long j) {
        f.abT().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long gK(int i) {
        return f.abT().getLong("max_age" + i, 0L);
    }

    private static long gL(int i) {
        return f.abT().getLong("latest_update_time" + i, 0L);
    }
}
