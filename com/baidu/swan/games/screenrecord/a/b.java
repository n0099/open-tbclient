package com.baidu.swan.games.screenrecord.a;

import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class b {
    private long ekA;
    private long ekB;
    private long ekC;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.ekA = j;
        this.ekB = j2;
        this.ekC = j3;
    }

    public a aYc() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.ekA - this.ekB, 0L);
        aVar.end = this.ekA + this.ekC;
        return aVar;
    }

    public boolean isValid() {
        return this.ekA >= 0 && this.ekB >= 0 && this.ekC >= 0 && this.ekB + this.ekC > 0 && this.ekA + this.ekC > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.ekA + "; mLeftOffset = " + this.ekB + "; mRightOffset = " + this.ekC + " ]";
    }
}
