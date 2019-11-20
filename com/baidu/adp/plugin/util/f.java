package com.baidu.adp.plugin.util;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int wH;
    int wI;
    int wJ;
    int wK;
    int wL;
    int wM;

    public final void c(int i, int i2, int i3, int i4, int i5, int i6) {
        this.wH = i;
        this.wI = i2;
        this.wJ = i3;
        this.wK = i4;
        this.wL = i5;
        this.wM = i6;
    }

    public String toString() {
        return this.wH + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.wI + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.wJ + HanziToPinyin.Token.SEPARATOR + this.wK + ":" + this.wL + ":" + this.wM;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.wH - fVar.wH > 0) {
            return 1;
        }
        if (this.wH - fVar.wH < 0) {
            return -1;
        }
        if (this.wI - fVar.wI <= 0) {
            if (this.wI - fVar.wI < 0) {
                return -1;
            }
            if (this.wJ - fVar.wJ <= 0) {
                if (this.wJ - fVar.wJ < 0) {
                    return -1;
                }
                if (this.wK - fVar.wK <= 0) {
                    if (this.wK - fVar.wK < 0) {
                        return -1;
                    }
                    if (this.wL - fVar.wL <= 0) {
                        if (this.wL - fVar.wL < 0) {
                            return -1;
                        }
                        if (this.wM - fVar.wM <= 0) {
                            return this.wM - fVar.wM < 0 ? -1 : 0;
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
