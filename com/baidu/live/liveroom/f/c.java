package com.baidu.live.liveroom.f;
/* loaded from: classes11.dex */
public class c {
    private static volatile c brS = null;
    private b brT = null;

    private c() {
    }

    public static c Na() {
        if (brS == null) {
            synchronized (c.class) {
                if (brS == null) {
                    brS = new c();
                }
            }
        }
        return brS;
    }

    public b Nb() {
        return this.brT;
    }
}
