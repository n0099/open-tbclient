package com.baidu.swan.c;

import com.baidu.swan.d.e;
/* loaded from: classes11.dex */
public final class b extends e {
    private static volatile b cFQ;

    public b() {
        super("aiapp_open_stat");
    }

    public static b awg() {
        if (cFQ == null) {
            synchronized (b.class) {
                if (cFQ == null) {
                    cFQ = new b();
                }
            }
        }
        return cFQ;
    }
}
