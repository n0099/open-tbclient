package com.baidu.swan.b;

import com.baidu.swan.c.i;
/* loaded from: classes17.dex */
public final class b extends i {
    private static volatile b est;

    public b() {
        super("aiapp_open_stat");
    }

    public static b bgH() {
        if (est == null) {
            synchronized (b.class) {
                if (est == null) {
                    est = new b();
                }
            }
        }
        return est;
    }
}
