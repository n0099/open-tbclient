package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class c {
    private static long Sd = 0;

    public static final synchronized boolean qm() {
        boolean z;
        synchronized (c.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - Sd > 1000) {
                Sd = currentTimeMillis;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
