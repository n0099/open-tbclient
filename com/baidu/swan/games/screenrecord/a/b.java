package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b {
    private long crN;
    private long crO;
    private long crP;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.crN = j;
        this.crO = j2;
        this.crP = j3;
    }

    public a apu() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.crN - this.crO, 0L);
        aVar.end = this.crN + this.crP;
        return aVar;
    }

    public boolean isValid() {
        return this.crN >= 0 && this.crO >= 0 && this.crP >= 0 && this.crO + this.crP > 0 && this.crN + this.crP > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.crN + "; mLeftOffset = " + this.crO + "; mRightOffset = " + this.crP + " ]";
    }
}
