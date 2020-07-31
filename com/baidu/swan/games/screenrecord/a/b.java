package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes7.dex */
public class b {
    private long dmr;
    private long dms;
    private long dmt;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.dmr = j;
        this.dms = j2;
        this.dmt = j3;
    }

    public a aGn() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.dmr - this.dms, 0L);
        aVar.end = this.dmr + this.dmt;
        return aVar;
    }

    public boolean isValid() {
        return this.dmr >= 0 && this.dms >= 0 && this.dmt >= 0 && this.dms + this.dmt > 0 && this.dmr + this.dmt > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.dmr + "; mLeftOffset = " + this.dms + "; mRightOffset = " + this.dmt + " ]";
    }
}
