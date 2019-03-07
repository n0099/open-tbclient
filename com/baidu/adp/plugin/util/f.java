package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int MB;
    int MC;
    int MD;
    int ME;
    int MF;
    int MG;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.MB = i;
        this.MC = i2;
        this.MD = i3;
        this.ME = i4;
        this.MF = i5;
        this.MG = i6;
    }

    public String toString() {
        return this.MB + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.MC + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.MD + " " + this.ME + ":" + this.MF + ":" + this.MG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.MB - fVar.MB > 0) {
            return 1;
        }
        if (this.MB - fVar.MB < 0) {
            return -1;
        }
        if (this.MC - fVar.MC <= 0) {
            if (this.MC - fVar.MC < 0) {
                return -1;
            }
            if (this.MD - fVar.MD <= 0) {
                if (this.MD - fVar.MD < 0) {
                    return -1;
                }
                if (this.ME - fVar.ME <= 0) {
                    if (this.ME - fVar.ME < 0) {
                        return -1;
                    }
                    if (this.MF - fVar.MF <= 0) {
                        if (this.MF - fVar.MF < 0) {
                            return -1;
                        }
                        if (this.MG - fVar.MG <= 0) {
                            return this.MG - fVar.MG < 0 ? -1 : 0;
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
