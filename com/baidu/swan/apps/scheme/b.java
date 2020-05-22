package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cBv;

    public static synchronized a apM() {
        a aVar;
        synchronized (b.class) {
            if (cBv == null) {
                cBv = new a();
            }
            aVar = cBv;
        }
        return aVar;
    }
}
