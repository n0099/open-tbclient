package com.baidu.live.liveroom.f;
/* loaded from: classes3.dex */
public class c {
    private static volatile c aQg = null;
    private b aQh = null;

    private c() {
    }

    public static c DI() {
        if (aQg == null) {
            synchronized (c.class) {
                if (aQg == null) {
                    aQg = new c();
                }
            }
        }
        return aQg;
    }

    public b DJ() {
        return this.aQh;
    }
}
