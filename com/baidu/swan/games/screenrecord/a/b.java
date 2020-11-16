package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes7.dex */
public class b {
    private long dXj;
    private long dXk;
    private long dXl;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.dXj = j;
        this.dXk = j2;
        this.dXl = j3;
    }

    public a aWk() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.dXj - this.dXk, 0L);
        aVar.end = this.dXj + this.dXl;
        return aVar;
    }

    public boolean isValid() {
        return this.dXj >= 0 && this.dXk >= 0 && this.dXl >= 0 && this.dXk + this.dXl > 0 && this.dXj + this.dXl > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.dXj + "; mLeftOffset = " + this.dXk + "; mRightOffset = " + this.dXl + " ]";
    }
}
