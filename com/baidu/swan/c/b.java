package com.baidu.swan.c;

import com.baidu.swan.d.i;
/* loaded from: classes9.dex */
public final class b extends i {
    private static volatile b dBr;

    public b() {
        super("aiapp_open_stat");
    }

    public static b aNW() {
        if (dBr == null) {
            synchronized (b.class) {
                if (dBr == null) {
                    dBr = new b();
                }
            }
        }
        return dBr;
    }
}
