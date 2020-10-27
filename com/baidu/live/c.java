package com.baidu.live;
/* loaded from: classes4.dex */
public class c {
    private static volatile c aAb;
    private boolean aAc;

    private c() {
    }

    public static c AY() {
        if (aAb == null) {
            synchronized (d.class) {
                if (aAb == null) {
                    aAb = new c();
                }
            }
        }
        return aAb;
    }

    public void aX(boolean z) {
        this.aAc = z;
    }
}
