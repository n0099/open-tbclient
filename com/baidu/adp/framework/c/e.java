package com.baidu.adp.framework.c;

import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class e {
    private int[] pq;

    public e(int i) {
        this.pq = null;
        this.pq = new int[1];
        this.pq[0] = i;
    }

    public e(int i, int i2, int i3) {
        this.pq = null;
        this.pq = new int[3];
        this.pq[0] = i;
        this.pq[1] = i2;
        this.pq[2] = i3;
    }

    public int getTimeOut() {
        if (this.pq == null || this.pq.length != 1) {
            return 0;
        }
        return this.pq[0];
    }

    public int de() {
        if (this.pq == null || this.pq.length != 3) {
            return 0;
        }
        switch (j.gV()) {
            case 1:
                return this.pq[2];
            case 2:
                return this.pq[0];
            case 3:
                return this.pq[1];
            default:
                return this.pq[2];
        }
    }
}
