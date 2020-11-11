package com.baidu.swan.b;

import com.baidu.swan.c.i;
/* loaded from: classes9.dex */
public final class b extends i {
    private static volatile b emY;

    public b() {
        super("aiapp_open_stat");
    }

    public static b bej() {
        if (emY == null) {
            synchronized (b.class) {
                if (emY == null) {
                    emY = new b();
                }
            }
        }
        return emY;
    }
}
