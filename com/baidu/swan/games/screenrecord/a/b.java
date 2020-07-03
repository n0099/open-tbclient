package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b {
    private long dgI;
    private long dgJ;
    private long dgK;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.dgI = j;
        this.dgJ = j2;
        this.dgK = j3;
    }

    public a aCG() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.dgI - this.dgJ, 0L);
        aVar.end = this.dgI + this.dgK;
        return aVar;
    }

    public boolean isValid() {
        return this.dgI >= 0 && this.dgJ >= 0 && this.dgK >= 0 && this.dgJ + this.dgK > 0 && this.dgI + this.dgK > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.dgI + "; mLeftOffset = " + this.dgJ + "; mRightOffset = " + this.dgK + " ]";
    }
}
