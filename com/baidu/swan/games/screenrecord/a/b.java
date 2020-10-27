package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class b {
    private long dSZ;
    private long dTa;
    private long dTb;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.dSZ = j;
        this.dTa = j2;
        this.dTb = j3;
    }

    public a aUs() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.dSZ - this.dTa, 0L);
        aVar.end = this.dSZ + this.dTb;
        return aVar;
    }

    public boolean isValid() {
        return this.dSZ >= 0 && this.dTa >= 0 && this.dTb >= 0 && this.dTa + this.dTb > 0 && this.dSZ + this.dTb > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.dSZ + "; mLeftOffset = " + this.dTa + "; mRightOffset = " + this.dTb + " ]";
    }
}
