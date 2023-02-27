package com.baidu.ar.auth;
/* loaded from: classes.dex */
public class m {
    public static long[] a(int i, long j) {
        int i2;
        if (j < 50) {
            j = 50;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = 0;
        while (true) {
            i2 = (currentTimeMillis > 946656000000L ? 1 : (currentTimeMillis == 946656000000L ? 0 : -1));
            if (i2 >= 0) {
                break;
            }
            int i4 = i3 + 1;
            if (i3 >= i) {
                break;
            }
            try {
                Thread.currentThread();
                Thread.sleep(j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = i4;
        }
        long[] jArr = new long[2];
        jArr[0] = i2 < 0 ? 0 : 1;
        jArr[1] = currentTimeMillis;
        return jArr;
    }
}
