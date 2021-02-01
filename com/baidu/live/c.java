package com.baidu.live;
/* loaded from: classes11.dex */
public class c {
    private static volatile c awe;
    private boolean awf;

    private c() {
    }

    public static c xb() {
        if (awe == null) {
            synchronized (d.class) {
                if (awe == null) {
                    awe = new c();
                }
            }
        }
        return awe;
    }

    public void aV(boolean z) {
        this.awf = z;
    }
}
