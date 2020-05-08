package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cpF;

    public static synchronized a alO() {
        a aVar;
        synchronized (b.class) {
            if (cpF == null) {
                cpF = new a();
            }
            aVar = cpF;
        }
        return aVar;
    }
}
