package com.baidu.swan.pms.d;

import com.baidu.swan.pms.e.f;
/* loaded from: classes2.dex */
public class a {
    public static boolean fN(int i) {
        return (System.currentTimeMillis() - fP(i)) / 1000 > fO(i);
    }

    public static void f(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        f.Xa().edit().putLong("max_age" + i, j).apply();
    }

    public static void g(int i, long j) {
        f.Xa().edit().putLong("latest_update_time" + i, j).apply();
    }

    private static long fO(int i) {
        return f.Xa().getLong("max_age" + i, 0L);
    }

    private static long fP(int i) {
        return f.Xa().getLong("latest_update_time" + i, 0L);
    }
}
