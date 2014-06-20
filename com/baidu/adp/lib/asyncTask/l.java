package com.baidu.adp.lib.asyncTask;
/* loaded from: classes.dex */
public final class l {
    private static int a = 1000;
    private int b = 0;

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            lVar = new l();
            lVar.b = a;
            a++;
        }
        return lVar;
    }

    private l() {
    }
}
