package com.baidu.adp.plugin.util;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int zD;
    int zE;
    int zF;
    int zG;
    int zH;
    int zI;

    public final void d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.zD = i;
        this.zE = i2;
        this.zF = i3;
        this.zG = i4;
        this.zH = i5;
        this.zI = i6;
    }

    public String toString() {
        return this.zD + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zF + HanziToPinyin.Token.SEPARATOR + this.zG + ":" + this.zH + ":" + this.zI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.zD - fVar.zD > 0) {
            return 1;
        }
        if (this.zD - fVar.zD < 0) {
            return -1;
        }
        if (this.zE - fVar.zE <= 0) {
            if (this.zE - fVar.zE < 0) {
                return -1;
            }
            if (this.zF - fVar.zF <= 0) {
                if (this.zF - fVar.zF < 0) {
                    return -1;
                }
                if (this.zG - fVar.zG <= 0) {
                    if (this.zG - fVar.zG < 0) {
                        return -1;
                    }
                    if (this.zH - fVar.zH <= 0) {
                        if (this.zH - fVar.zH < 0) {
                            return -1;
                        }
                        if (this.zI - fVar.zI <= 0) {
                            return this.zI - fVar.zI < 0 ? -1 : 0;
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
