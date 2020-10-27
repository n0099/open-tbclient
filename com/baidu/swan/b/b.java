package com.baidu.swan.b;

import com.baidu.swan.c.i;
/* loaded from: classes9.dex */
public final class b extends i {
    private static volatile b ehh;

    public b() {
        super("aiapp_open_stat");
    }

    public static b bbJ() {
        if (ehh == null) {
            synchronized (b.class) {
                if (ehh == null) {
                    ehh = new b();
                }
            }
        }
        return ehh;
    }
}
