package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b {
    private long cQZ;
    private long cRa;
    private long cRb;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.cQZ = j;
        this.cRa = j2;
        this.cRb = j3;
    }

    public a axJ() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.cQZ - this.cRa, 0L);
        aVar.end = this.cQZ + this.cRb;
        return aVar;
    }

    public boolean isValid() {
        return this.cQZ >= 0 && this.cRa >= 0 && this.cRb >= 0 && this.cRa + this.cRb > 0 && this.cQZ + this.cRb > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.cQZ + "; mLeftOffset = " + this.cRa + "; mRightOffset = " + this.cRb + " ]";
    }
}
