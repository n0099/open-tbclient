package com.baidu.live;
/* loaded from: classes10.dex */
public class c {
    private static volatile c awp;
    private boolean awq;

    private c() {
    }

    public static c xe() {
        if (awp == null) {
            synchronized (d.class) {
                if (awp == null) {
                    awp = new c();
                }
            }
        }
        return awp;
    }

    public void aV(boolean z) {
        this.awq = z;
    }
}
