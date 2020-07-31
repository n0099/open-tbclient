package com.baidu.live;
/* loaded from: classes4.dex */
public class b {
    private static volatile b atH;
    private boolean atI;

    private b() {
    }

    public static b ve() {
        if (atH == null) {
            synchronized (c.class) {
                if (atH == null) {
                    atH = new b();
                }
            }
        }
        return atH;
    }

    public void aP(boolean z) {
        this.atI = z;
    }
}
