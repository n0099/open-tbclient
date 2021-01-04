package com.baidu.swan.games.screenrecord.a;

import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class b {
    private long eng;
    private long enh;
    private long eni;

    @NonNull
    public static b a(long j, double d, double d2) {
        return new b(j, (long) (d * 1000.0d), (long) (d2 * 1000.0d));
    }

    public b(long j, long j2, long j3) {
        this.eng = j;
        this.enh = j2;
        this.eni = j3;
    }

    public a bbJ() {
        if (!isValid()) {
            return null;
        }
        a aVar = new a();
        aVar.start = Math.max(this.eng - this.enh, 0L);
        aVar.end = this.eng + this.eni;
        return aVar;
    }

    public boolean isValid() {
        return this.eng >= 0 && this.enh >= 0 && this.eni >= 0 && this.enh + this.eni > 0 && this.eng + this.eni > 0;
    }

    public String toString() {
        return "[ mBaseline = " + this.eng + "; mLeftOffset = " + this.enh + "; mRightOffset = " + this.eni + " ]";
    }
}
