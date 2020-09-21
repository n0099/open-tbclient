package com.baidu.live;
/* loaded from: classes4.dex */
public class b {
    private static volatile b azn;
    private boolean azo;

    private b() {
    }

    public static b AQ() {
        if (azn == null) {
            synchronized (c.class) {
                if (azn == null) {
                    azn = new b();
                }
            }
        }
        return azn;
    }

    public void aU(boolean z) {
        this.azo = z;
    }
}
