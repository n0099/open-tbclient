package com.baidu.swan.apps.u.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a axs;

    public static synchronized a Dq() {
        a aVar;
        synchronized (b.class) {
            if (axs == null) {
                axs = new a();
            }
            aVar = axs;
        }
        return aVar;
    }
}
