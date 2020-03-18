package com.baidu.j.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a aQh;

    public static synchronized a ED() {
        a aVar;
        synchronized (b.class) {
            if (aQh == null) {
                aQh = new a();
            }
            aVar = aQh;
        }
        return aVar;
    }
}
