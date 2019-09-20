package com.baidu.swan.pms.d;

import com.baidu.swan.pms.e.f;
/* loaded from: classes2.dex */
public class a {
    public static boolean fO(int i) {
        return (System.currentTimeMillis() - fQ(i)) / 1000 > fP(i);
    }

    public static void f(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        f.Xe().edit().putLong("max_age" + i, j).apply();
    }

    public static void g(int i, long j) {
        f.Xe().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long fP(int i) {
        return f.Xe().getLong("max_age" + i, 0L);
    }

    private static long fQ(int i) {
        return f.Xe().getLong("latest_update_time" + i, 0L);
    }
}
