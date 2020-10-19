package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class b {
    private long dKC;
    private long dKD;
    private long dKE;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.dKC = j;
        this.dKD = j2;
        this.dKE = j3;
    }

    public a aSy() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.dKC - this.dKD, 0L);
        aVar.end = this.dKC + this.dKE;
        return aVar;
    }

    public boolean isValid() {
        return this.dKC >= 0 && this.dKD >= 0 && this.dKE >= 0 && this.dKD + this.dKE > 0 && this.dKC + this.dKE > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.dKC + "; mLeftOffset = " + this.dKD + "; mRightOffset = " + this.dKE + " ]";
    }
}
