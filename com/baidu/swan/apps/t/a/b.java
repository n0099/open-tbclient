package com.baidu.swan.apps.t.a;
/* loaded from: classes14.dex */
public class b {
    private static volatile a cnL;

    public static synchronized a aiy() {
        a aVar;
        synchronized (b.class) {
            if (cnL == null) {
                cnL = new a();
            }
            aVar = cnL;
        }
        return aVar;
    }
}
