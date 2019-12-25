package com.baidu.swan.c;

import com.baidu.swan.d.e;
/* loaded from: classes9.dex */
public final class b extends e {
    private static volatile b cBu;

    public b() {
        super("aiapp_open_stat");
    }

    public static b atu() {
        if (cBu == null) {
            synchronized (b.class) {
                if (cBu == null) {
                    cBu = new b();
                }
            }
        }
        return cBu;
    }
}
