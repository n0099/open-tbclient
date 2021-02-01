package com.baidu.helios.common.b.a;
/* loaded from: classes4.dex */
public class e {
    private long asR;

    public e() {
        this(0L);
    }

    public e(long j) {
        this.asR = j;
    }

    public boolean g(long j, long j2) {
        long j3 = this.asR;
        this.asR = (this.asR & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.asR) != 0;
    }

    public void O(long j) {
        this.asR = j;
    }

    public long P(long j) {
        return this.asR & j;
    }

    public long ve() {
        return this.asR;
    }
}
