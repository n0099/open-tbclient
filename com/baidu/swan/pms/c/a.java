package com.baidu.swan.pms.c;

import com.baidu.swan.pms.d.f;
/* loaded from: classes2.dex */
public class a {
    public static boolean AF() {
        return (System.currentTimeMillis() - Sn()) / 1000 > Sm();
    }

    public static void V(long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        f.Sw().edit().putLong("max_age", j).apply();
    }

    public static void W(long j) {
        f.Sw().edit().putLong("latest_update_time", j).apply();
    }

    private static long Sm() {
        return f.Sw().getLong("max_age", 0L);
    }

    private static long Sn() {
        return f.Sw().getLong("latest_update_time", 0L);
    }
}
