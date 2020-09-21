package com.baidu.swan.b;

import com.baidu.swan.c.i;
/* loaded from: classes14.dex */
public final class b extends i {
    private static volatile b dMJ;

    public b() {
        super("aiapp_open_stat");
    }

    public static b aXi() {
        if (dMJ == null) {
            synchronized (b.class) {
                if (dMJ == null) {
                    dMJ = new b();
                }
            }
        }
        return dMJ;
    }
}
