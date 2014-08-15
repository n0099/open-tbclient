package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class c {
    private static long a = 0;

    public static final synchronized boolean a() {
        boolean z;
        synchronized (c.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a > 1000) {
                a = currentTimeMillis;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
