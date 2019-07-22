package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes2.dex */
public class b {
    private long bkC;
    private long bkD;
    private long bkE;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.bkC = j;
        this.bkD = j2;
        this.bkE = j3;
    }

    public a SY() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.bkA = Math.max(this.bkC - this.bkD, 0L);
        aVar.bkB = this.bkC + this.bkE;
        return aVar;
    }

    public boolean isValid() {
        return this.bkC >= 0 && this.bkD >= 0 && this.bkE >= 0 && this.bkD + this.bkE > 0 && this.bkC + this.bkE > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.bkC + "; mLeftOffset = " + this.bkD + "; mRightOffset = " + this.bkE + " ]";
    }
}
