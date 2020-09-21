package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {
    private long dyB;
    private long dyC;
    private long dyD;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.dyB = j;
        this.dyC = j2;
        this.dyD = j3;
    }

    public a aPP() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.dyB - this.dyC, 0L);
        aVar.end = this.dyB + this.dyD;
        return aVar;
    }

    public boolean isValid() {
        return this.dyB >= 0 && this.dyC >= 0 && this.dyD >= 0 && this.dyC + this.dyD > 0 && this.dyB + this.dyD > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.dyB + "; mLeftOffset = " + this.dyC + "; mRightOffset = " + this.dyD + " ]";
    }
}
