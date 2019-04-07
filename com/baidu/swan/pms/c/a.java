package com.baidu.swan.pms.c;

import com.baidu.swan.pms.d.f;
/* loaded from: classes2.dex */
public class a {
    public static boolean AE() {
        return (System.currentTimeMillis() - Sl()) / 1000 > Sk();
    }

    public static void V(long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        f.Su().edit().putLong("max_age", j).apply();
    }

    public static void W(long j) {
        f.Su().edit().putLong("latest_update_time", j).apply();
    }

    private static long Sk() {
        return f.Su().getLong("max_age", 0L);
    }

    private static long Sl() {
        return f.Su().getLong("latest_update_time", 0L);
    }
}
