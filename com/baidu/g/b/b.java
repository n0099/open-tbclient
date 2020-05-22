package com.baidu.g.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a btL;

    public static synchronized a MH() {
        a aVar;
        synchronized (b.class) {
            if (btL == null) {
                btL = new a();
            }
            aVar = btL;
        }
        return aVar;
    }
}
