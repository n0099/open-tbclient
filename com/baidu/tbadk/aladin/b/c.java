package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class c {
    private static long xo = 0;

    public static final synchronized boolean iN() {
        boolean z;
        synchronized (c.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - xo > 1000) {
                xo = currentTimeMillis;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
