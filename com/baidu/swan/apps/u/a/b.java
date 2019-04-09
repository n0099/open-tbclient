package com.baidu.swan.apps.u.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a axw;

    public static synchronized a Do() {
        a aVar;
        synchronized (b.class) {
            if (axw == null) {
                axw = new a();
            }
            aVar = axw;
        }
        return aVar;
    }
}
