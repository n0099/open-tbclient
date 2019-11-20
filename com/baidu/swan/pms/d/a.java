package com.baidu.swan.pms.d;

import com.baidu.swan.pms.e.f;
/* loaded from: classes2.dex */
public class a {
    public static boolean gI(int i) {
        return (System.currentTimeMillis() - gK(i)) / 1000 > gJ(i);
    }

    public static void d(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        f.abR().edit().putLong("max_age" + i, j).apply();
    }

    public static void e(int i, long j) {
        f.abR().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long gJ(int i) {
        return f.abR().getLong("max_age" + i, 0L);
    }

    private static long gK(int i) {
        return f.abR().getLong("latest_update_time" + i, 0L);
    }
}
