package com.baidu.helios.common.b.a;
/* loaded from: classes8.dex */
public class e {
    private long ayh;

    public e() {
        this(0L);
    }

    public e(long j) {
        this.ayh = j;
    }

    public boolean d(long j, long j2) {
        long j3 = this.ayh;
        this.ayh = (this.ayh & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.ayh) != 0;
    }

    public void R(long j) {
        this.ayh = j;
    }

    public long S(long j) {
        return this.ayh & j;
    }

    public long AA() {
        return this.ayh;
    }
}
