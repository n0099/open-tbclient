package com.baidu.swan.apps.scheme;
/* loaded from: classes4.dex */
public class b {
    private static volatile a bLK;

    public static synchronized a aaU() {
        a aVar;
        synchronized (b.class) {
            if (bLK == null) {
                bLK = new a();
            }
            aVar = bLK;
        }
        return aVar;
    }
}
