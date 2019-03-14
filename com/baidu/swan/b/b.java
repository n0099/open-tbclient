package com.baidu.swan.b;

import com.baidu.swan.c.d;
/* loaded from: classes2.dex */
public final class b extends d {
    private static volatile b bqh;

    public b() {
        super("aiapp_open_stat");
    }

    public static b TD() {
        if (bqh == null) {
            synchronized (b.class) {
                if (bqh == null) {
                    bqh = new b();
                }
            }
        }
        return bqh;
    }
}
