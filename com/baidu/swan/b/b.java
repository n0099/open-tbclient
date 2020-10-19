package com.baidu.swan.b;

import com.baidu.swan.c.i;
/* loaded from: classes9.dex */
public final class b extends i {
    private static volatile b dYK;

    public b() {
        super("aiapp_open_stat");
    }

    public static b aZQ() {
        if (dYK == null) {
            synchronized (b.class) {
                if (dYK == null) {
                    dYK = new b();
                }
            }
        }
        return dYK;
    }
}
