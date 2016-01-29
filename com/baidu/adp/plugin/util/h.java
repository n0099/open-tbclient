package com.baidu.adp.plugin.util;
/* loaded from: classes.dex */
public class h implements Comparable<h> {
    int FA;
    int FB;
    int FC;
    int Fx;
    int Fy;
    int Fz;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.Fx = i;
        this.Fy = i2;
        this.Fz = i3;
        this.FA = i4;
        this.FB = i5;
        this.FC = i6;
    }

    public String toString() {
        return String.valueOf(this.Fx) + "-" + this.Fy + "-" + this.Fz + " " + this.FA + ":" + this.FB + ":" + this.FC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(h hVar) {
        if (this.Fx - hVar.Fx > 0) {
            return 1;
        }
        if (this.Fx - hVar.Fx < 0) {
            return -1;
        }
        if (this.Fy - hVar.Fy <= 0) {
            if (this.Fy - hVar.Fy < 0) {
                return -1;
            }
            if (this.Fz - hVar.Fz <= 0) {
                if (this.Fz - hVar.Fz < 0) {
                    return -1;
                }
                if (this.FA - hVar.FA <= 0) {
                    if (this.FA - hVar.FA < 0) {
                        return -1;
                    }
                    if (this.FB - hVar.FB <= 0) {
                        if (this.FB - hVar.FB < 0) {
                            return -1;
                        }
                        if (this.FC - hVar.FC <= 0) {
                            return this.FC - hVar.FC < 0 ? -1 : 0;
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
