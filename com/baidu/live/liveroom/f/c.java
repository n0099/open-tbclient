package com.baidu.live.liveroom.f;
/* loaded from: classes3.dex */
public class c {
    private static volatile c aWp = null;
    private b aWq = null;

    private c() {
    }

    public static c Fg() {
        if (aWp == null) {
            synchronized (c.class) {
                if (aWp == null) {
                    aWp = new c();
                }
            }
        }
        return aWp;
    }

    public b Fh() {
        return this.aWq;
    }
}
