package com.baidu.live.liveroom.f;
/* loaded from: classes3.dex */
public class c {
    private static volatile c awm = null;
    private b awn = null;

    private c() {
    }

    public static c yK() {
        if (awm == null) {
            synchronized (c.class) {
                if (awm == null) {
                    awm = new c();
                }
            }
        }
        return awm;
    }

    public b yL() {
        return this.awn;
    }
}
