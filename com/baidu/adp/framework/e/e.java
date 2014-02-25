package com.baidu.adp.framework.e;
/* loaded from: classes.dex */
public class e {
    private int[] a;

    public e(int i, int i2, int i3) {
        this.a = null;
        this.a = new int[3];
        this.a[0] = i;
        this.a[1] = i2;
        this.a[2] = i3;
    }

    public int a() {
        if (this.a == null || this.a.length != 1) {
            return 0;
        }
        return this.a[0];
    }
}
