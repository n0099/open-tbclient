package com.baidu.live;
/* loaded from: classes6.dex */
public class b {
    private static b MT;
    private boolean MU;

    private b() {
    }

    public static b no() {
        if (MT == null) {
            synchronized (c.class) {
                if (MT == null) {
                    MT = new b();
                }
            }
        }
        return MT;
    }

    public void aa(boolean z) {
        this.MU = z;
    }
}
