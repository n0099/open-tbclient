package com.baidu.k.b;
/* loaded from: classes6.dex */
public class b {
    private static volatile a cop;

    public static synchronized a adj() {
        a aVar;
        synchronized (b.class) {
            if (cop == null) {
                cop = new a();
            }
            aVar = cop;
        }
        return aVar;
    }
}
