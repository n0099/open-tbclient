package com.baidu.helios.common.b.a;
/* loaded from: classes5.dex */
public class e {
    private long axu;

    public e() {
        this(0L);
    }

    public e(long j) {
        this.axu = j;
    }

    public boolean d(long j, long j2) {
        long j3 = this.axu;
        this.axu = (this.axu & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.axu) != 0;
    }

    public void P(long j) {
        this.axu = j;
    }

    public long Q(long j) {
        return this.axu & j;
    }

    public long zL() {
        return this.axu;
    }
}
