package com.baidu.adp.plugin.util;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int zl;
    int zm;
    int zn;
    int zo;
    int zp;
    int zq;

    public final void d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.zl = i;
        this.zm = i2;
        this.zn = i3;
        this.zo = i4;
        this.zp = i5;
        this.zq = i6;
    }

    public String toString() {
        return this.zl + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zm + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zn + HanziToPinyin.Token.SEPARATOR + this.zo + ":" + this.zp + ":" + this.zq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.zl - fVar.zl > 0) {
            return 1;
        }
        if (this.zl - fVar.zl < 0) {
            return -1;
        }
        if (this.zm - fVar.zm <= 0) {
            if (this.zm - fVar.zm < 0) {
                return -1;
            }
            if (this.zn - fVar.zn <= 0) {
                if (this.zn - fVar.zn < 0) {
                    return -1;
                }
                if (this.zo - fVar.zo <= 0) {
                    if (this.zo - fVar.zo < 0) {
                        return -1;
                    }
                    if (this.zp - fVar.zp <= 0) {
                        if (this.zp - fVar.zp < 0) {
                            return -1;
                        }
                        if (this.zq - fVar.zq <= 0) {
                            return this.zq - fVar.zq < 0 ? -1 : 0;
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
