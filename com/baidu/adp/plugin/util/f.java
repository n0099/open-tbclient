package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int Mk;
    int Ml;
    int mDay;
    int mMinute;
    int mMonth;
    int mYear;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mYear = i;
        this.mMonth = i2;
        this.mDay = i3;
        this.Mk = i4;
        this.mMinute = i5;
        this.Ml = i6;
    }

    public String toString() {
        return this.mYear + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mMonth + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mDay + " " + this.Mk + ":" + this.mMinute + ":" + this.Ml;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.mYear - fVar.mYear > 0) {
            return 1;
        }
        if (this.mYear - fVar.mYear < 0) {
            return -1;
        }
        if (this.mMonth - fVar.mMonth <= 0) {
            if (this.mMonth - fVar.mMonth < 0) {
                return -1;
            }
            if (this.mDay - fVar.mDay <= 0) {
                if (this.mDay - fVar.mDay < 0) {
                    return -1;
                }
                if (this.Mk - fVar.Mk <= 0) {
                    if (this.Mk - fVar.Mk < 0) {
                        return -1;
                    }
                    if (this.mMinute - fVar.mMinute <= 0) {
                        if (this.mMinute - fVar.mMinute < 0) {
                            return -1;
                        }
                        if (this.Ml - fVar.Ml <= 0) {
                            return this.Ml - fVar.Ml < 0 ? -1 : 0;
                        }
                        return 1;
                    }
                    return 1;
                }
                return 1;
            }
            return 1;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && compareTo((f) obj) == 0;
    }
}
