package com.baidu.live;
/* loaded from: classes2.dex */
public class b {
    private static b TS;
    private boolean TT;

    private b() {
    }

    public static b oI() {
        if (TS == null) {
            synchronized (c.class) {
                if (TS == null) {
                    TS = new b();
                }
            }
        }
        return TS;
    }

    public void aj(boolean z) {
        this.TT = z;
    }
}
