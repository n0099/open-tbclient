package com.baidu.swan.apps.t.a;
/* loaded from: classes14.dex */
public class b {
    private static volatile a cvp;

    public static synchronized a aqe() {
        a aVar;
        synchronized (b.class) {
            if (cvp == null) {
                cvp = new a();
            }
            aVar = cvp;
        }
        return aVar;
    }
}
