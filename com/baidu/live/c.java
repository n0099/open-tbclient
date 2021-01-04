package com.baidu.live;
/* loaded from: classes11.dex */
public class c {
    private static volatile c aBc;
    private boolean aBd;

    private c() {
    }

    public static c AZ() {
        if (aBc == null) {
            synchronized (d.class) {
                if (aBc == null) {
                    aBc = new c();
                }
            }
        }
        return aBc;
    }

    public void aZ(boolean z) {
        this.aBd = z;
    }
}
