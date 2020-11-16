package com.baidu.live.liveroom.f;
/* loaded from: classes4.dex */
public class c {
    private static volatile c bmc = null;
    private b bmd = null;

    private c() {
    }

    public static c Np() {
        if (bmc == null) {
            synchronized (c.class) {
                if (bmc == null) {
                    bmc = new c();
                }
            }
        }
        return bmc;
    }

    public b Nq() {
        return this.bmd;
    }
}
