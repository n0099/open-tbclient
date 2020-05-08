package com.baidu.live;
/* loaded from: classes3.dex */
public class b {
    private static volatile b anz;
    private boolean anA;

    private b() {
    }

    public static b tF() {
        if (anz == null) {
            synchronized (c.class) {
                if (anz == null) {
                    anz = new b();
                }
            }
        }
        return anz;
    }

    public void aJ(boolean z) {
        this.anA = z;
    }
}
