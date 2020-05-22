package com.baidu.swan.d;

import com.baidu.swan.e.j;
/* loaded from: classes11.dex */
public final class b extends j {
    private static volatile b dqP;

    public b() {
        super("aiapp_open_stat");
    }

    public static b aIZ() {
        if (dqP == null) {
            synchronized (b.class) {
                if (dqP == null) {
                    dqP = new b();
                }
            }
        }
        return dqP;
    }
}
