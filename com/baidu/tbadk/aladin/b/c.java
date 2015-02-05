package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class c {
    private static long Ax = 0;

    public static final synchronized boolean kS() {
        boolean z;
        synchronized (c.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - Ax > 1000) {
                Ax = currentTimeMillis;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
