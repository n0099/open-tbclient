package com.baidu.swan.bdprivate.extensions.f;
/* loaded from: classes19.dex */
public class b {
    private static volatile a dHL;

    public static synchronized a aNX() {
        a aVar;
        synchronized (b.class) {
            if (dHL == null) {
                dHL = new a();
            }
            aVar = dHL;
        }
        return aVar;
    }
}
