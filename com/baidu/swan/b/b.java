package com.baidu.swan.b;

import com.baidu.swan.c.d;
/* loaded from: classes2.dex */
public final class b extends d {
    private static volatile b bql;

    public b() {
        super("aiapp_open_stat");
    }

    public static b TB() {
        if (bql == null) {
            synchronized (b.class) {
                if (bql == null) {
                    bql = new b();
                }
            }
        }
        return bql;
    }
}
