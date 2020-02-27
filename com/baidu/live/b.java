package com.baidu.live;
/* loaded from: classes3.dex */
public class b {
    private static volatile b Vx;
    private boolean Vy;

    private b() {
    }

    public static b pq() {
        if (Vx == null) {
            synchronized (c.class) {
                if (Vx == null) {
                    Vx = new b();
                }
            }
        }
        return Vx;
    }

    public void am(boolean z) {
        this.Vy = z;
    }
}
