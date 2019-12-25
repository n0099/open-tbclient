package com.baidu.swan.pms.e;

import com.baidu.swan.pms.f.f;
/* loaded from: classes9.dex */
public class a {
    public static void j(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        f.agq().edit().putLong("max_age" + i, j).apply();
    }

    public static void k(int i, long j) {
        f.agq().edit().putLong("latest_update_time" + i, j).apply();
    }
}
