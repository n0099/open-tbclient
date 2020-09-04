package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes8.dex */
public class b {
    private long dwA;
    private long dwB;
    private long dwC;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.dwA = j;
        this.dwB = j2;
        this.dwC = j3;
    }

    public a aPe() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.dwA - this.dwB, 0L);
        aVar.end = this.dwA + this.dwC;
        return aVar;
    }

    public boolean isValid() {
        return this.dwA >= 0 && this.dwB >= 0 && this.dwC >= 0 && this.dwB + this.dwC > 0 && this.dwA + this.dwC > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.dwA + "; mLeftOffset = " + this.dwB + "; mRightOffset = " + this.dwC + " ]";
    }
}
