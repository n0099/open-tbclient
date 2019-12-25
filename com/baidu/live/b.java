package com.baidu.live;
/* loaded from: classes2.dex */
public class b {
    private static b TP;
    private boolean TQ;

    private b() {
    }

    public static b oH() {
        if (TP == null) {
            synchronized (c.class) {
                if (TP == null) {
                    TP = new b();
                }
            }
        }
        return TP;
    }

    public void aj(boolean z) {
        this.TQ = z;
    }
}
