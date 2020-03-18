package com.baidu.live.liveroom.f;
/* loaded from: classes3.dex */
public class c {
    private static volatile c awx = null;
    private b awy = null;

    private c() {
    }

    public static c yP() {
        if (awx == null) {
            synchronized (c.class) {
                if (awx == null) {
                    awx = new c();
                }
            }
        }
        return awx;
    }

    public b yQ() {
        return this.awy;
    }
}
