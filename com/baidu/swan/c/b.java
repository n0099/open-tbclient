package com.baidu.swan.c;

import com.baidu.swan.d.e;
/* loaded from: classes11.dex */
public final class b extends e {
    private static volatile b cFD;

    public b() {
        super("aiapp_open_stat");
    }

    public static b awb() {
        if (cFD == null) {
            synchronized (b.class) {
                if (cFD == null) {
                    cFD = new b();
                }
            }
        }
        return cFD;
    }
}
