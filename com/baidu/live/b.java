package com.baidu.live;
/* loaded from: classes7.dex */
public class b {
    private static volatile b ayJ;
    private boolean ayK;

    private b() {
    }

    public static b AC() {
        if (ayJ == null) {
            synchronized (c.class) {
                if (ayJ == null) {
                    ayJ = new b();
                }
            }
        }
        return ayJ;
    }

    public void aU(boolean z) {
        this.ayK = z;
    }
}
