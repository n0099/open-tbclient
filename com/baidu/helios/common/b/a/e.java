package com.baidu.helios.common.b.a;
/* loaded from: classes12.dex */
public class e {
    private long arW;

    public e() {
        this(0L);
    }

    public e(long j) {
        this.arW = j;
    }

    public boolean d(long j, long j2) {
        long j3 = this.arW;
        this.arW = (this.arW & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.arW) != 0;
    }

    public void R(long j) {
        this.arW = j;
    }

    public long S(long j) {
        return this.arW & j;
    }

    public long uH() {
        return this.arW;
    }
}
