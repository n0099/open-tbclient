package com.baidu.live;
/* loaded from: classes6.dex */
public class b {
    private static b Nt;
    private boolean Nu;

    private b() {
    }

    public static b no() {
        if (Nt == null) {
            synchronized (c.class) {
                if (Nt == null) {
                    Nt = new b();
                }
            }
        }
        return Nt;
    }

    public void aa(boolean z) {
        this.Nu = z;
    }
}
