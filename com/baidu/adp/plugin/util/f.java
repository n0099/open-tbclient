package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int Ue;
    int Uf;
    int Ug;
    int Uh;
    int Ui;
    int Uj;

    public final void c(int i, int i2, int i3, int i4, int i5, int i6) {
        this.Ue = i;
        this.Uf = i2;
        this.Ug = i3;
        this.Uh = i4;
        this.Ui = i5;
        this.Uj = i6;
    }

    public String toString() {
        return this.Ue + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Uf + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ug + " " + this.Uh + ":" + this.Ui + ":" + this.Uj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.Ue - fVar.Ue > 0) {
            return 1;
        }
        if (this.Ue - fVar.Ue < 0) {
            return -1;
        }
        if (this.Uf - fVar.Uf <= 0) {
            if (this.Uf - fVar.Uf < 0) {
                return -1;
            }
            if (this.Ug - fVar.Ug <= 0) {
                if (this.Ug - fVar.Ug < 0) {
                    return -1;
                }
                if (this.Uh - fVar.Uh <= 0) {
                    if (this.Uh - fVar.Uh < 0) {
                        return -1;
                    }
                    if (this.Ui - fVar.Ui <= 0) {
                        if (this.Ui - fVar.Ui < 0) {
                            return -1;
                        }
                        if (this.Uj - fVar.Uj <= 0) {
                            return this.Uj - fVar.Uj < 0 ? -1 : 0;
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
