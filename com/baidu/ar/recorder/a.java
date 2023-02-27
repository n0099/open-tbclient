package com.baidu.ar.recorder;
/* loaded from: classes.dex */
public class a {
    public long uz;
    public int uy = 100;
    public long uA = 0;
    public boolean iO = false;

    public a(long j) {
        this.uz = 0L;
        this.uz = j;
    }

    public boolean fI() {
        return this.iO;
    }

    public void t(long j) {
        this.uA = j;
        this.iO = true;
    }

    public int u(long j) {
        long j2 = this.uz;
        if (j2 != 0) {
            long j3 = this.uA;
            if (j3 == 0) {
                return 0;
            }
            return (int) (((j - j3) * this.uy) / j2);
        }
        return 0;
    }
}
