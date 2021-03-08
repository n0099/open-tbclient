package com.baidu.swan.gamecenter.c;
/* loaded from: classes6.dex */
public class e {
    private static volatile d eds;

    public static synchronized d aTH() {
        d dVar;
        synchronized (e.class) {
            if (eds == null) {
                eds = new d();
            }
            dVar = eds;
        }
        return dVar;
    }
}
