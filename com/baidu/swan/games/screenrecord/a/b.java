package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b {
    private long crZ;
    private long csa;
    private long csb;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.crZ = j;
        this.csa = j2;
        this.csb = j3;
    }

    public a apx() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.crZ - this.csa, 0L);
        aVar.end = this.crZ + this.csb;
        return aVar;
    }

    public boolean isValid() {
        return this.crZ >= 0 && this.csa >= 0 && this.csb >= 0 && this.csa + this.csb > 0 && this.crZ + this.csb > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.crZ + "; mLeftOffset = " + this.csa + "; mRightOffset = " + this.csb + " ]";
    }
}
