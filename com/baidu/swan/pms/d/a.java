package com.baidu.swan.pms.d;

import com.baidu.swan.pms.e.f;
/* loaded from: classes2.dex */
public class a {
    public static boolean fJ(int i) {
        return (System.currentTimeMillis() - fL(i)) / 1000 > fK(i);
    }

    public static void f(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        f.Wg().edit().putLong("max_age" + i, j).apply();
    }

    public static void g(int i, long j) {
        f.Wg().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long fK(int i) {
        return f.Wg().getLong("max_age" + i, 0L);
    }

    private static long fL(int i) {
        return f.Wg().getLong("latest_update_time" + i, 0L);
    }
}
