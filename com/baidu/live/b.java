package com.baidu.live;
/* loaded from: classes3.dex */
public class b {
    private static volatile b VH;
    private boolean VI;

    private b() {
    }

    public static b pv() {
        if (VH == null) {
            synchronized (c.class) {
                if (VH == null) {
                    VH = new b();
                }
            }
        }
        return VH;
    }

    public void am(boolean z) {
        this.VI = z;
    }
}
