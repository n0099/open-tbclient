package com.baidu.helios.common.b.a;
/* loaded from: classes6.dex */
public class e {
    private long asa;

    public e() {
        this(0L);
    }

    public e(long j) {
        this.asa = j;
    }

    public boolean d(long j, long j2) {
        long j3 = this.asa;
        this.asa = (this.asa & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.asa) != 0;
    }

    public void R(long j) {
        this.asa = j;
    }

    public long S(long j) {
        return this.asa & j;
    }

    public long uH() {
        return this.asa;
    }
}
