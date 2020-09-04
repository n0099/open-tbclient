package com.baidu.live.liveroom.f;
/* loaded from: classes7.dex */
public class c {
    private static volatile c ber = null;
    private b bes = null;

    private c() {
    }

    public static c Lx() {
        if (ber == null) {
            synchronized (c.class) {
                if (ber == null) {
                    ber = new c();
                }
            }
        }
        return ber;
    }

    public b Ly() {
        return this.bes;
    }
}
