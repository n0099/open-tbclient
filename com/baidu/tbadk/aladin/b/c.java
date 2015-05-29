package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class c {
    private static long Nt = 0;

    public static final synchronized boolean pl() {
        boolean z;
        synchronized (c.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - Nt > 1000) {
                Nt = currentTimeMillis;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
