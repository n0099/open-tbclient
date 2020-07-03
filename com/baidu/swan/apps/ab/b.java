package com.baidu.swan.apps.ab;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cvy;

    public static synchronized a amb() {
        a aVar;
        synchronized (b.class) {
            if (cvy == null) {
                cvy = new a();
            }
            aVar = cvy;
        }
        return aVar;
    }
}
