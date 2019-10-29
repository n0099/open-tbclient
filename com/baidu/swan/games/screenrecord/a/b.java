package com.baidu.swan.games.screenrecord.a;

import android.support.annotation.NonNull;
/* loaded from: classes2.dex */
public class b {
    private long bDO;
    private long bDP;
    private long bDQ;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.bDO = j;
        this.bDP = j2;
        this.bDQ = j3;
    }

    public a XT() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.bDM = Math.max(this.bDO - this.bDP, 0L);
        aVar.bDN = this.bDO + this.bDQ;
        return aVar;
    }

    public boolean isValid() {
        return this.bDO >= 0 && this.bDP >= 0 && this.bDQ >= 0 && this.bDP + this.bDQ > 0 && this.bDO + this.bDQ > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.bDO + "; mLeftOffset = " + this.bDP + "; mRightOffset = " + this.bDQ + " ]";
    }
}
