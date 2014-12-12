package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class c {
    private static long AA = 0;

    public static final synchronized boolean kZ() {
        boolean z;
        synchronized (c.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - AA > 1000) {
                AA = currentTimeMillis;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
