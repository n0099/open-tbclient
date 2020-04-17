package com.baidu.live.liveroom.f;
/* loaded from: classes3.dex */
public class c {
    private static volatile c aQa = null;
    private b aQb = null;

    private c() {
    }

    public static c DJ() {
        if (aQa == null) {
            synchronized (c.class) {
                if (aQa == null) {
                    aQa = new c();
                }
            }
        }
        return aQa;
    }

    public b DK() {
        return this.aQb;
    }
}
