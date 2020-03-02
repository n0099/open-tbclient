package com.baidu.swan.c;

import com.baidu.swan.d.e;
/* loaded from: classes11.dex */
public final class b extends e {
    private static volatile b cFE;

    public b() {
        super("aiapp_open_stat");
    }

    public static b awd() {
        if (cFE == null) {
            synchronized (b.class) {
                if (cFE == null) {
                    cFE = new b();
                }
            }
        }
        return cFE;
    }
}
