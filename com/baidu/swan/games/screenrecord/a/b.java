package com.baidu.swan.games.screenrecord.a;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class b {
    private long eit;
    private long eiu;
    private long eiv;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.eit = j;
        this.eiu = j2;
        this.eiv = j3;
    }

    public a aXQ() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.eit - this.eiu, 0L);
        aVar.end = this.eit + this.eiv;
        return aVar;
    }

    public boolean isValid() {
        return this.eit >= 0 && this.eiu >= 0 && this.eiv >= 0 && this.eiu + this.eiv > 0 && this.eit + this.eiv > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.eit + "; mLeftOffset = " + this.eiu + "; mRightOffset = " + this.eiv + " ]";
    }
}
