package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes2.dex */
public class b {
    private long bCX;
    private long bCY;
    private long bCZ;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.bCX = j;
        this.bCY = j2;
        this.bCZ = j3;
    }

    public a XR() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.bCV = Math.max(this.bCX - this.bCY, 0L);
        aVar.bCW = this.bCX + this.bCZ;
        return aVar;
    }

    public boolean isValid() {
        return this.bCX >= 0 && this.bCY >= 0 && this.bCZ >= 0 && this.bCY + this.bCZ > 0 && this.bCX + this.bCZ > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.bCX + "; mLeftOffset = " + this.bCY + "; mRightOffset = " + this.bCZ + " ]";
    }
}
