package com.baidu.swan.b;

import com.baidu.swan.c.i;
/* loaded from: classes14.dex */
public final class b extends i {
    private static volatile b eAY;

    public b() {
        super("aiapp_open_stat");
    }

    public static b bfA() {
        if (eAY == null) {
            synchronized (b.class) {
                if (eAY == null) {
                    eAY = new b();
                }
            }
        }
        return eAY;
    }
}
