package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class h implements Comparable<h> {
    int EY;
    int EZ;
    int Fa;
    int Fb;
    int Fc;
    int Fd;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.EY = i;
        this.EZ = i2;
        this.Fa = i3;
        this.Fb = i4;
        this.Fc = i5;
        this.Fd = i6;
    }

    public String toString() {
        return String.valueOf(this.EY) + "-" + this.EZ + "-" + this.Fa + " " + this.Fb + ":" + this.Fc + ":" + this.Fd;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(h hVar) {
        if (this.EY - hVar.EY > 0) {
            return 1;
        }
        if (this.EY - hVar.EY < 0) {
            return -1;
        }
        if (this.EZ - hVar.EZ <= 0) {
            if (this.EZ - hVar.EZ < 0) {
                return -1;
            }
            if (this.Fa - hVar.Fa <= 0) {
                if (this.Fa - hVar.Fa < 0) {
                    return -1;
                }
                if (this.Fb - hVar.Fb <= 0) {
                    if (this.Fb - hVar.Fb < 0) {
                        return -1;
                    }
                    if (this.Fc - hVar.Fc <= 0) {
                        if (this.Fc - hVar.Fc < 0) {
                            return -1;
                        }
                        if (this.Fd - hVar.Fd <= 0) {
                            return this.Fd - hVar.Fd < 0 ? -1 : 0;
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
        return (obj instanceof h) && compareTo((h) obj) == 0;
    }
}
