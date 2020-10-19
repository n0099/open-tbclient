package com.baidu.live.liveroom.f;
/* loaded from: classes4.dex */
public class c {
    private static volatile c bkY = null;
    private b bkZ = null;

    private c() {
    }

    public static c Ne() {
        if (bkY == null) {
            synchronized (c.class) {
                if (bkY == null) {
                    bkY = new c();
                }
            }
        }
        return bkY;
    }

    public b Nf() {
        return this.bkZ;
    }
}
