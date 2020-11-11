package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class b {
    private long dYR;
    private long dYS;
    private long dYT;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.dYR = j;
        this.dYS = j2;
        this.dYT = j3;
    }

    public a aWS() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.dYR - this.dYS, 0L);
        aVar.end = this.dYR + this.dYT;
        return aVar;
    }

    public boolean isValid() {
        return this.dYR >= 0 && this.dYS >= 0 && this.dYT >= 0 && this.dYS + this.dYT > 0 && this.dYR + this.dYT > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.dYR + "; mLeftOffset = " + this.dYS + "; mRightOffset = " + this.dYT + " ]";
    }
}
