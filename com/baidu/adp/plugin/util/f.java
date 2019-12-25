package com.baidu.adp.plugin.util;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int zh;
    int zi;
    int zj;
    int zk;
    int zl;
    int zm;

    public final void d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.zh = i;
        this.zi = i2;
        this.zj = i3;
        this.zk = i4;
        this.zl = i5;
        this.zm = i6;
    }

    public String toString() {
        return this.zh + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zi + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.zj + HanziToPinyin.Token.SEPARATOR + this.zk + ":" + this.zl + ":" + this.zm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.zh - fVar.zh > 0) {
            return 1;
        }
        if (this.zh - fVar.zh < 0) {
            return -1;
        }
        if (this.zi - fVar.zi <= 0) {
            if (this.zi - fVar.zi < 0) {
                return -1;
            }
            if (this.zj - fVar.zj <= 0) {
                if (this.zj - fVar.zj < 0) {
                    return -1;
                }
                if (this.zk - fVar.zk <= 0) {
                    if (this.zk - fVar.zk < 0) {
                        return -1;
                    }
                    if (this.zl - fVar.zl <= 0) {
                        if (this.zl - fVar.zl < 0) {
                            return -1;
                        }
                        if (this.zm - fVar.zm <= 0) {
                            return this.zm - fVar.zm < 0 ? -1 : 0;
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
