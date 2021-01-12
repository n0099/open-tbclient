package com.baidu.swan.b;

import com.baidu.swan.c.i;
/* loaded from: classes6.dex */
public final class b extends i {
    private static volatile b exo;

    public b() {
        super("aiapp_open_stat");
    }

    public static b bfl() {
        if (exo == null) {
            synchronized (b.class) {
                if (exo == null) {
                    exo = new b();
                }
            }
        }
        return exo;
    }
}
