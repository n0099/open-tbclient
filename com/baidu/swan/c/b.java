package com.baidu.swan.c;

import com.baidu.swan.d.e;
/* loaded from: classes11.dex */
public final class b extends e {
    private static volatile b deW;

    public b() {
        super("aiapp_open_stat");
    }

    public static b aEr() {
        if (deW == null) {
            synchronized (b.class) {
                if (deW == null) {
                    deW = new b();
                }
            }
        }
        return deW;
    }
}
