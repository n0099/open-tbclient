package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class c {
    private static long Nf = 0;

    public static final synchronized boolean oL() {
        boolean z;
        synchronized (c.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - Nf > 1000) {
                Nf = currentTimeMillis;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
