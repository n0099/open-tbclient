package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b {
    private long cQU;
    private long cQV;
    private long cQW;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.cQU = j;
        this.cQV = j2;
        this.cQW = j3;
    }

    public a axJ() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.cQU - this.cQV, 0L);
        aVar.end = this.cQU + this.cQW;
        return aVar;
    }

    public boolean isValid() {
        return this.cQU >= 0 && this.cQV >= 0 && this.cQW >= 0 && this.cQV + this.cQW > 0 && this.cQU + this.cQW > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.cQU + "; mLeftOffset = " + this.cQV + "; mRightOffset = " + this.cQW + " ]";
    }
}
