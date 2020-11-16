package com.baidu.swan.b;

import com.baidu.swan.c.i;
/* loaded from: classes16.dex */
public final class b extends i {
    private static volatile b elr;

    public b() {
        super("aiapp_open_stat");
    }

    public static b bdC() {
        if (elr == null) {
            synchronized (b.class) {
                if (elr == null) {
                    elr = new b();
                }
            }
        }
        return elr;
    }
}
