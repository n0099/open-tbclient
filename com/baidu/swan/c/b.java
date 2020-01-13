package com.baidu.swan.c;

import com.baidu.swan.d.e;
/* loaded from: classes10.dex */
public final class b extends e {
    private static volatile b cBF;

    public b() {
        super("aiapp_open_stat");
    }

    public static b atN() {
        if (cBF == null) {
            synchronized (b.class) {
                if (cBF == null) {
                    cBF = new b();
                }
            }
        }
        return cBF;
    }
}
