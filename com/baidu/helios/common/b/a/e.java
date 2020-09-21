package com.baidu.helios.common.b.a;
/* loaded from: classes6.dex */
public class e {
    private long axx;

    public e() {
        this(0L);
    }

    public e(long j) {
        this.axx = j;
    }

    public boolean d(long j, long j2) {
        long j3 = this.axx;
        this.axx = (this.axx & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.axx) != 0;
    }

    public void R(long j) {
        this.axx = j;
    }

    public long S(long j) {
        return this.axx & j;
    }

    public long As() {
        return this.axx;
    }
}
