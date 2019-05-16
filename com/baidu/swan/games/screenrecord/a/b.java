package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes2.dex */
public class b {
    private long bjP;
    private long bjQ;
    private long bjR;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.bjP = j;
        this.bjQ = j2;
        this.bjR = j3;
    }

    public a Sf() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.bjN = Math.max(this.bjP - this.bjQ, 0L);
        aVar.bjO = this.bjP + this.bjR;
        return aVar;
    }

    public boolean isValid() {
        return this.bjP >= 0 && this.bjQ >= 0 && this.bjR >= 0 && this.bjQ + this.bjR > 0 && this.bjP + this.bjR > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.bjP + "; mLeftOffset = " + this.bjQ + "; mRightOffset = " + this.bjR + " ]";
    }
}
