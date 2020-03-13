package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b {
    private long crO;
    private long crP;
    private long crQ;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.crO = j;
        this.crP = j2;
        this.crQ = j3;
    }

    public a apu() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.crO - this.crP, 0L);
        aVar.end = this.crO + this.crQ;
        return aVar;
    }

    public boolean isValid() {
        return this.crO >= 0 && this.crP >= 0 && this.crQ >= 0 && this.crP + this.crQ > 0 && this.crO + this.crQ > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.crO + "; mLeftOffset = " + this.crP + "; mRightOffset = " + this.crQ + " ]";
    }
}
