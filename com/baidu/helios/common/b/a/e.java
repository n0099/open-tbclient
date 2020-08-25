package com.baidu.helios.common.b.a;
/* loaded from: classes4.dex */
public class e {
    private long awT;

    public e() {
        this(0L);
    }

    public e(long j) {
        this.awT = j;
    }

    public boolean d(long j, long j2) {
        long j3 = this.awT;
        this.awT = (this.awT & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.awT) != 0;
    }

    public void S(long j) {
        this.awT = j;
    }

    public long T(long j) {
        return this.awT & j;
    }

    public long Ae() {
        return this.awT;
    }
}
