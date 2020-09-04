package com.baidu.swan.b;

import com.baidu.swan.c.i;
/* loaded from: classes10.dex */
public final class b extends i {
    private static volatile b dKG;

    public b() {
        super("aiapp_open_stat");
    }

    public static b aWw() {
        if (dKG == null) {
            synchronized (b.class) {
                if (dKG == null) {
                    dKG = new b();
                }
            }
        }
        return dKG;
    }
}
