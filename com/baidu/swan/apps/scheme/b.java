package com.baidu.swan.apps.scheme;
/* loaded from: classes20.dex */
public class b {
    private static volatile a duG;

    public static synchronized a aIz() {
        a aVar;
        synchronized (b.class) {
            if (duG == null) {
                duG = new a();
            }
            aVar = duG;
        }
        return aVar;
    }
}
