package com.baidu.live.liveroom.f;
/* loaded from: classes4.dex */
public class c {
    private static volatile c aYW = null;
    private b aYX = null;

    private c() {
    }

    public static c FJ() {
        if (aYW == null) {
            synchronized (c.class) {
                if (aYW == null) {
                    aYW = new c();
                }
            }
        }
        return aYW;
    }

    public b FK() {
        return this.aYX;
    }
}
