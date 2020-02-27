package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class b {
    private static volatile a bQz;

    public static synchronized a adF() {
        a aVar;
        synchronized (b.class) {
            if (bQz == null) {
                bQz = new a();
            }
            aVar = bQz;
        }
        return aVar;
    }
}
