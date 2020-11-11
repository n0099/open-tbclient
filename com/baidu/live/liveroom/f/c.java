package com.baidu.live.liveroom.f;
/* loaded from: classes4.dex */
public class c {
    private static volatile c bnN = null;
    private b bnO = null;

    private c() {
    }

    public static c NY() {
        if (bnN == null) {
            synchronized (c.class) {
                if (bnN == null) {
                    bnN = new c();
                }
            }
        }
        return bnN;
    }

    public b NZ() {
        return this.bnO;
    }
}
