package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes8.dex */
public class b {
    private long dww;
    private long dwx;
    private long dwy;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.dww = j;
        this.dwx = j2;
        this.dwy = j3;
    }

    public a aPe() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.dww - this.dwx, 0L);
        aVar.end = this.dww + this.dwy;
        return aVar;
    }

    public boolean isValid() {
        return this.dww >= 0 && this.dwx >= 0 && this.dwy >= 0 && this.dwx + this.dwy > 0 && this.dww + this.dwy > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.dww + "; mLeftOffset = " + this.dwx + "; mRightOffset = " + this.dwy + " ]";
    }
}
