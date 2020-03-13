package com.baidu.live.liveroom.f;
/* loaded from: classes3.dex */
public class c {
    private static volatile c awn = null;
    private b awo = null;

    private c() {
    }

    public static c yK() {
        if (awn == null) {
            synchronized (c.class) {
                if (awn == null) {
                    awn = new c();
                }
            }
        }
        return awn;
    }

    public b yL() {
        return this.awo;
    }
}
