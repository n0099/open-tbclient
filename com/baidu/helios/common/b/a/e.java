package com.baidu.helios.common.b.a;
/* loaded from: classes8.dex */
public class e {
    private long ayg;

    public e() {
        this(0L);
    }

    public e(long j) {
        this.ayg = j;
    }

    public boolean d(long j, long j2) {
        long j3 = this.ayg;
        this.ayg = (this.ayg & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.ayg) != 0;
    }

    public void R(long j) {
        this.ayg = j;
    }

    public long S(long j) {
        return this.ayg & j;
    }

    public long AA() {
        return this.ayg;
    }
}
