package com.baidu.m.b;
/* loaded from: classes20.dex */
public class b {
    private static volatile a cgj;

    public static synchronized a ado() {
        a aVar;
        synchronized (b.class) {
            if (cgj == null) {
                cgj = new a();
            }
            aVar = cgj;
        }
        return aVar;
    }
}
