package com.baidu.swan.apps.u.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ayk;

    public static synchronized a Et() {
        a aVar;
        synchronized (b.class) {
            if (ayk == null) {
                ayk = new a();
            }
            aVar = ayk;
        }
        return aVar;
    }
}
