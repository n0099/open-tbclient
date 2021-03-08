package com.baidu.live.liveroom.f;
/* loaded from: classes10.dex */
public class c {
    private static volatile c btt = null;
    private b btu = null;

    private c() {
    }

    public static c Nd() {
        if (btt == null) {
            synchronized (c.class) {
                if (btt == null) {
                    btt = new c();
                }
            }
        }
        return btt;
    }

    public b Ne() {
        return this.btu;
    }
}
