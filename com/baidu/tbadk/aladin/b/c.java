package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class c {
    private static long Sb = 0;

    public static final synchronized boolean qj() {
        boolean z;
        synchronized (c.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - Sb > 1000) {
                Sb = currentTimeMillis;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
