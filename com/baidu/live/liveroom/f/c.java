package com.baidu.live.liveroom.f;
/* loaded from: classes7.dex */
public class c {
    private static volatile c bep = null;
    private b beq = null;

    private c() {
    }

    public static c Lx() {
        if (bep == null) {
            synchronized (c.class) {
                if (bep == null) {
                    bep = new c();
                }
            }
        }
        return bep;
    }

    public b Ly() {
        return this.beq;
    }
}
