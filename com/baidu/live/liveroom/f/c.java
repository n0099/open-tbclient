package com.baidu.live.liveroom.f;
/* loaded from: classes4.dex */
public class c {
    private static volatile c bmt = null;
    private b bmu = null;

    private c() {
    }

    public static c Ny() {
        if (bmt == null) {
            synchronized (c.class) {
                if (bmt == null) {
                    bmt = new c();
                }
            }
        }
        return bmt;
    }

    public b Nz() {
        return this.bmu;
    }
}
