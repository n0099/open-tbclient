package com.baidu.helios.common.b.a;
/* loaded from: classes15.dex */
public class e {
    private long axN;

    public e() {
        this(0L);
    }

    public e(long j) {
        this.axN = j;
    }

    public boolean g(long j, long j2) {
        long j3 = this.axN;
        this.axN = (this.axN & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.axN) != 0;
    }

    public void O(long j) {
        this.axN = j;
    }

    public long P(long j) {
        return this.axN & j;
    }

    public long zc() {
        return this.axN;
    }
}
