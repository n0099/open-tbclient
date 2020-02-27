package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b {
    private long crM;
    private long crN;
    private long crO;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.crM = j;
        this.crN = j2;
        this.crO = j3;
    }

    public a aps() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.crM - this.crN, 0L);
        aVar.end = this.crM + this.crO;
        return aVar;
    }

    public boolean isValid() {
        return this.crM >= 0 && this.crN >= 0 && this.crO >= 0 && this.crN + this.crO > 0 && this.crM + this.crO > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.crM + "; mLeftOffset = " + this.crN + "; mRightOffset = " + this.crO + " ]";
    }
}
