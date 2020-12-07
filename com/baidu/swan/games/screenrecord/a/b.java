package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes25.dex */
public class b {
    private long eei;
    private long eej;
    private long eek;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.eei = j;
        this.eej = j2;
        this.eek = j3;
    }

    public a aZp() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.eei - this.eej, 0L);
        aVar.end = this.eei + this.eek;
        return aVar;
    }

    public boolean isValid() {
        return this.eei >= 0 && this.eej >= 0 && this.eek >= 0 && this.eej + this.eek > 0 && this.eei + this.eek > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.eei + "; mLeftOffset = " + this.eej + "; mRightOffset = " + this.eek + " ]";
    }
}
