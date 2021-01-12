package com.baidu.helios.common.b.a;
/* loaded from: classes3.dex */
public class e {
    private long atb;

    public e() {
        this(0L);
    }

    public e(long j) {
        this.atb = j;
    }

    public boolean g(long j, long j2) {
        long j3 = this.atb;
        this.atb = (this.atb & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.atb) != 0;
    }

    public void O(long j) {
        this.atb = j;
    }

    public long P(long j) {
        return this.atb & j;
    }

    public long vh() {
        return this.atb;
    }
}
