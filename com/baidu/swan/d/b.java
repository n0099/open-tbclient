package com.baidu.swan.d;

import com.baidu.swan.e.j;
/* loaded from: classes11.dex */
public final class b extends j {
    private static volatile b dvB;

    public b() {
        super("aiapp_open_stat");
    }

    public static b aKf() {
        if (dvB == null) {
            synchronized (b.class) {
                if (dvB == null) {
                    dvB = new b();
                }
            }
        }
        return dvB;
    }
}
