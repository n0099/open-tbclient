package com.baidu.helios.common.b.a;
/* loaded from: classes3.dex */
public class e {
    private long aur;

    public e() {
        this(0L);
    }

    public e(long j) {
        this.aur = j;
    }

    public boolean g(long j, long j2) {
        long j3 = this.aur;
        this.aur = (this.aur & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.aur) != 0;
    }

    public void O(long j) {
        this.aur = j;
    }

    public long P(long j) {
        return this.aur & j;
    }

    public long vh() {
        return this.aur;
    }
}
