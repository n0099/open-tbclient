package com.baidu.live.liveroom.f;
/* loaded from: classes4.dex */
public class c {
    private static volatile c brj = null;
    private b brk = null;

    private c() {
    }

    public static c PI() {
        if (brj == null) {
            synchronized (c.class) {
                if (brj == null) {
                    brj = new c();
                }
            }
        }
        return brj;
    }

    public b PJ() {
        return this.brk;
    }
}
