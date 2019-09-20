package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes2.dex */
public class b {
    private long bla;
    private long blb;
    private long blc;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.bla = j;
        this.blb = j2;
        this.blc = j3;
    }

    public a Tc() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.bkY = Math.max(this.bla - this.blb, 0L);
        aVar.bkZ = this.bla + this.blc;
        return aVar;
    }

    public boolean isValid() {
        return this.bla >= 0 && this.blb >= 0 && this.blc >= 0 && this.blb + this.blc > 0 && this.bla + this.blc > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.bla + "; mLeftOffset = " + this.blb + "; mRightOffset = " + this.blc + " ]";
    }
}
