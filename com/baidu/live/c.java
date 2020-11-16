package com.baidu.live;
/* loaded from: classes4.dex */
public class c {
    private static volatile c ayq;
    private boolean ayr;

    private c() {
    }

    public static c Ap() {
        if (ayq == null) {
            synchronized (d.class) {
                if (ayq == null) {
                    ayq = new c();
                }
            }
        }
        return ayq;
    }

    public void aZ(boolean z) {
        this.ayr = z;
    }
}
