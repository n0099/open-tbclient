package com.baidu.k.b;
/* loaded from: classes6.dex */
public class b {
    private static volatile a ciy;

    public static synchronized a abs() {
        a aVar;
        synchronized (b.class) {
            if (ciy == null) {
                ciy = new a();
            }
            aVar = ciy;
        }
        return aVar;
    }
}
