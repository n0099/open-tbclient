package com.baidu.live;
/* loaded from: classes4.dex */
public class c {
    private static volatile c aAL;
    private boolean aAM;

    private c() {
    }

    public static c BL() {
        if (aAL == null) {
            synchronized (d.class) {
                if (aAL == null) {
                    aAL = new c();
                }
            }
        }
        return aAL;
    }

    public void bc(boolean z) {
        this.aAM = z;
    }
}
