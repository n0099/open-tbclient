package com.baidu.swan.b;

import com.baidu.swan.c.d;
/* loaded from: classes2.dex */
public final class b extends d {
    private static volatile b bqg;

    public b() {
        super("aiapp_open_stat");
    }

    public static b TD() {
        if (bqg == null) {
            synchronized (b.class) {
                if (bqg == null) {
                    bqg = new b();
                }
            }
        }
        return bqg;
    }
}
