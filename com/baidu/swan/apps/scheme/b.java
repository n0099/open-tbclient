package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class b {
    private static volatile a bQM;

    public static synchronized a adK() {
        a aVar;
        synchronized (b.class) {
            if (bQM == null) {
                bQM = new a();
            }
            aVar = bQM;
        }
        return aVar;
    }
}
