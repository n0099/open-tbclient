package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b {
    private long dbV;
    private long dbW;
    private long dbX;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.dbV = j;
        this.dbW = j2;
        this.dbX = j3;
    }

    public a aBA() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.dbV - this.dbW, 0L);
        aVar.end = this.dbV + this.dbX;
        return aVar;
    }

    public boolean isValid() {
        return this.dbV >= 0 && this.dbW >= 0 && this.dbX >= 0 && this.dbW + this.dbX > 0 && this.dbV + this.dbX > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.dbV + "; mLeftOffset = " + this.dbW + "; mRightOffset = " + this.dbX + " ]";
    }
}
