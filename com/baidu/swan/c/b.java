package com.baidu.swan.c;

import com.baidu.swan.d.e;
/* loaded from: classes11.dex */
public final class b extends e {
    private static volatile b deR;

    public b() {
        super("aiapp_open_stat");
    }

    public static b aEr() {
        if (deR == null) {
            synchronized (b.class) {
                if (deR == null) {
                    deR = new b();
                }
            }
        }
        return deR;
    }
}
