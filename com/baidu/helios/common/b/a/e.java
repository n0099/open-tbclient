package com.baidu.helios.common.b.a;
/* loaded from: classes11.dex */
public class e {
    private long aww;

    public e() {
        this(0L);
    }

    public e(long j) {
        this.aww = j;
    }

    public boolean d(long j, long j2) {
        long j3 = this.aww;
        this.aww = (this.aww & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.aww) != 0;
    }

    public void R(long j) {
        this.aww = j;
    }

    public long S(long j) {
        return this.aww & j;
    }

    public long zR() {
        return this.aww;
    }
}
