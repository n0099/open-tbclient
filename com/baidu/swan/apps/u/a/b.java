package com.baidu.swan.apps.u.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a axv;

    public static synchronized a Do() {
        a aVar;
        synchronized (b.class) {
            if (axv == null) {
                axv = new a();
            }
            aVar = axv;
        }
        return aVar;
    }
}
