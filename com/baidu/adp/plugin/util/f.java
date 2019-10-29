package com.baidu.adp.plugin.util;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int xh;
    int xi;
    int xj;
    int xk;
    int xl;
    int xm;

    public final void c(int i, int i2, int i3, int i4, int i5, int i6) {
        this.xh = i;
        this.xi = i2;
        this.xj = i3;
        this.xk = i4;
        this.xl = i5;
        this.xm = i6;
    }

    public String toString() {
        return this.xh + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.xi + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.xj + HanziToPinyin.Token.SEPARATOR + this.xk + ":" + this.xl + ":" + this.xm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.xh - fVar.xh > 0) {
            return 1;
        }
        if (this.xh - fVar.xh < 0) {
            return -1;
        }
        if (this.xi - fVar.xi <= 0) {
            if (this.xi - fVar.xi < 0) {
                return -1;
            }
            if (this.xj - fVar.xj <= 0) {
                if (this.xj - fVar.xj < 0) {
                    return -1;
                }
                if (this.xk - fVar.xk <= 0) {
                    if (this.xk - fVar.xk < 0) {
                        return -1;
                    }
                    if (this.xl - fVar.xl <= 0) {
                        if (this.xl - fVar.xl < 0) {
                            return -1;
                        }
                        if (this.xm - fVar.xm <= 0) {
                            return this.xm - fVar.xm < 0 ? -1 : 0;
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
