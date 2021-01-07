package com.baidu.swan.b;

import com.baidu.swan.c.i;
/* loaded from: classes6.dex */
public final class b extends i {
    private static volatile b eCd;

    public b() {
        super("aiapp_open_stat");
    }

    public static b bjf() {
        if (eCd == null) {
            synchronized (b.class) {
                if (eCd == null) {
                    eCd = new b();
                }
            }
        }
        return eCd;
    }
}
