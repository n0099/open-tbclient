package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class b {
    private static volatile a bQA;

    public static synchronized a adH() {
        a aVar;
        synchronized (b.class) {
            if (bQA == null) {
                bQA = new a();
            }
            aVar = bQA;
        }
        return aVar;
    }
}
