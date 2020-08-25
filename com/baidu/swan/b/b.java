package com.baidu.swan.b;

import com.baidu.swan.c.i;
/* loaded from: classes10.dex */
public final class b extends i {
    private static volatile b dKC;

    public b() {
        super("aiapp_open_stat");
    }

    public static b aWw() {
        if (dKC == null) {
            synchronized (b.class) {
                if (dKC == null) {
                    dKC = new b();
                }
            }
        }
        return dKC;
    }
}
