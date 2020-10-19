package com.baidu.minivideo.arface.bean;
/* loaded from: classes15.dex */
public class a {
    public boolean bMf = true;
    public boolean bMg = true;
    public boolean bMh = true;
    public boolean bMi = true;

    public void dg(boolean z) {
        this.bMf = z;
    }

    public void dh(boolean z) {
        this.bMg = z;
    }

    public void di(boolean z) {
        this.bMh = z;
    }

    public void dj(boolean z) {
        this.bMi = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).bMh == this.bMh && ((a) obj).bMi == this.bMi && ((a) obj).bMg == this.bMg);
    }
}
