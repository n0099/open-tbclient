package com.baidu.live.liveroom.f;
/* loaded from: classes3.dex */
public class c {
    private static volatile c aYY = null;
    private b aYZ = null;

    private c() {
    }

    public static c FP() {
        if (aYY == null) {
            synchronized (c.class) {
                if (aYY == null) {
                    aYY = new c();
                }
            }
        }
        return aYY;
    }

    public b FQ() {
        return this.aYZ;
    }
}
