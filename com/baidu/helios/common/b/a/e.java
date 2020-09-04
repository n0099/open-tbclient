package com.baidu.helios.common.b.a;
/* loaded from: classes4.dex */
public class e {
    private long awV;

    public e() {
        this(0L);
    }

    public e(long j) {
        this.awV = j;
    }

    public boolean d(long j, long j2) {
        long j3 = this.awV;
        this.awV = (this.awV & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.awV) != 0;
    }

    public void S(long j) {
        this.awV = j;
    }

    public long T(long j) {
        return this.awV & j;
    }

    public long Ae() {
        return this.awV;
    }
}
