package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int De;
    int Df;
    int Dg;
    int Dh;
    int Di;
    int Dj;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.De = i;
        this.Df = i2;
        this.Dg = i3;
        this.Dh = i4;
        this.Di = i5;
        this.Dj = i6;
    }

    public String toString() {
        return this.De + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Df + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Dg + " " + this.Dh + ":" + this.Di + ":" + this.Dj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.De - fVar.De > 0) {
            return 1;
        }
        if (this.De - fVar.De < 0) {
            return -1;
        }
        if (this.Df - fVar.Df <= 0) {
            if (this.Df - fVar.Df < 0) {
                return -1;
            }
            if (this.Dg - fVar.Dg <= 0) {
                if (this.Dg - fVar.Dg < 0) {
                    return -1;
                }
                if (this.Dh - fVar.Dh <= 0) {
                    if (this.Dh - fVar.Dh < 0) {
                        return -1;
                    }
                    if (this.Di - fVar.Di <= 0) {
                        if (this.Di - fVar.Di < 0) {
                            return -1;
                        }
                        if (this.Dj - fVar.Dj <= 0) {
                            return this.Dj - fVar.Dj < 0 ? -1 : 0;
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
