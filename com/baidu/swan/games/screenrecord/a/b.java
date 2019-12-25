package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes9.dex */
public class b {
    private long cnx;
    private long cny;
    private long cnz;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.cnx = j;
        this.cny = j2;
        this.cnz = j3;
    }

    public a amL() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.cnx - this.cny, 0L);
        aVar.end = this.cnx + this.cnz;
        return aVar;
    }

    public boolean isValid() {
        return this.cnx >= 0 && this.cny >= 0 && this.cnz >= 0 && this.cny + this.cnz > 0 && this.cnx + this.cnz > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.cnx + "; mLeftOffset = " + this.cny + "; mRightOffset = " + this.cnz + " ]";
    }
}
