package com.baidu.ar.auth;
/* loaded from: classes3.dex */
class m {
    public static long[] a(int i, long j) {
        if (j < 50) {
            j = 50;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        while (currentTimeMillis < 946656000000L) {
            int i3 = i2 + 1;
            if (i2 >= i) {
                break;
            }
            try {
                Thread.currentThread();
                Thread.sleep(j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentTimeMillis = System.currentTimeMillis();
            i2 = i3;
        }
        long[] jArr = new long[2];
        jArr[0] = currentTimeMillis < 946656000000L ? 0 : 1;
        jArr[1] = currentTimeMillis;
        return jArr;
    }
}
