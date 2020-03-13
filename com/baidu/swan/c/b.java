package com.baidu.swan.c;

import com.baidu.swan.d.e;
/* loaded from: classes11.dex */
public final class b extends e {
    private static volatile b cFF;

    public b() {
        super("aiapp_open_stat");
    }

    public static b awd() {
        if (cFF == null) {
            synchronized (b.class) {
                if (cFF == null) {
                    cFF = new b();
                }
            }
        }
        return cFF;
    }
}
