package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class b {
    private long cnK;
    private long cnL;
    private long cnM;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.cnK = j;
        this.cnL = j2;
        this.cnM = j3;
    }

    public a ane() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.cnK - this.cnL, 0L);
        aVar.end = this.cnK + this.cnM;
        return aVar;
    }

    public boolean isValid() {
        return this.cnK >= 0 && this.cnL >= 0 && this.cnM >= 0 && this.cnL + this.cnM > 0 && this.cnK + this.cnM > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.cnK + "; mLeftOffset = " + this.cnL + "; mRightOffset = " + this.cnM + " ]";
    }
}
