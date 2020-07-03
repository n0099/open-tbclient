package com.baidu.live;
/* loaded from: classes3.dex */
public class b {
    private static volatile b atL;
    private boolean atM;

    private b() {
    }

    public static b ve() {
        if (atL == null) {
            synchronized (c.class) {
                if (atL == null) {
                    atL = new b();
                }
            }
        }
        return atL;
    }

    public void aM(boolean z) {
        this.atM = z;
    }
}
