package com.baidu.live.liveroom.f;
/* loaded from: classes4.dex */
public class c {
    private static volatile c bhi = null;
    private b bhj = null;

    private c() {
    }

    public static c LZ() {
        if (bhi == null) {
            synchronized (c.class) {
                if (bhi == null) {
                    bhi = new c();
                }
            }
        }
        return bhi;
    }

    public b Ma() {
        return this.bhj;
    }
}
