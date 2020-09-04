package com.baidu.live;
/* loaded from: classes7.dex */
public class b {
    private static volatile b ayL;
    private boolean ayM;

    private b() {
    }

    public static b AC() {
        if (ayL == null) {
            synchronized (c.class) {
                if (ayL == null) {
                    ayL = new b();
                }
            }
        }
        return ayL;
    }

    public void aU(boolean z) {
        this.ayM = z;
    }
}
