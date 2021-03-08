package com.baidu.swan.games.screenrecord.a;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class b {
    private long emb;
    private long emc;
    private long emd;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.emb = j;
        this.emc = j2;
        this.emd = j3;
    }

    public a aYf() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.emb - this.emc, 0L);
        aVar.end = this.emb + this.emd;
        return aVar;
    }

    public boolean isValid() {
        return this.emb >= 0 && this.emc >= 0 && this.emd >= 0 && this.emc + this.emd > 0 && this.emb + this.emd > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.emb + "; mLeftOffset = " + this.emc + "; mRightOffset = " + this.emd + " ]";
    }
}
