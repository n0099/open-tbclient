package com.baidu.helios.common.b.a;
/* loaded from: classes6.dex */
public class e {
    private long aqI;

    public e() {
        this(0L);
    }

    public e(long j) {
        this.aqI = j;
    }

    public boolean d(long j, long j2) {
        long j3 = this.aqI;
        this.aqI = (this.aqI & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.aqI) != 0;
    }

    public void R(long j) {
        this.aqI = j;
    }

    public long S(long j) {
        return this.aqI & j;
    }

    public long up() {
        return this.aqI;
    }
}
