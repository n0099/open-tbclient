package com.baidu.live.liveroom.f;
/* loaded from: classes3.dex */
public class c {
    private static volatile c awl = null;
    private b awm = null;

    private c() {
    }

    public static c yJ() {
        if (awl == null) {
            synchronized (c.class) {
                if (awl == null) {
                    awl = new c();
                }
            }
        }
        return awl;
    }

    public b yK() {
        return this.awm;
    }
}
