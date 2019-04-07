package com.baidu.swan.b;

import com.baidu.swan.c.d;
/* loaded from: classes2.dex */
public final class b extends d {
    private static volatile b bqk;

    public b() {
        super("aiapp_open_stat");
    }

    public static b TB() {
        if (bqk == null) {
            synchronized (b.class) {
                if (bqk == null) {
                    bqk = new b();
                }
            }
        }
        return bqk;
    }
}
