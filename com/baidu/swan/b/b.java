package com.baidu.swan.b;

import com.baidu.swan.c.i;
/* loaded from: classes15.dex */
public final class b extends i {
    private static volatile b ezx;

    public b() {
        super("aiapp_open_stat");
    }

    public static b bfy() {
        if (ezx == null) {
            synchronized (b.class) {
                if (ezx == null) {
                    ezx = new b();
                }
            }
        }
        return ezx;
    }
}
