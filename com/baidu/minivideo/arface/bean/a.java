package com.baidu.minivideo.arface.bean;
/* loaded from: classes3.dex */
public class a {
    public boolean bwf = true;
    public boolean bwg = true;
    public boolean bwh = true;
    public boolean bwi = true;

    public void cN(boolean z) {
        this.bwf = z;
    }

    public void cO(boolean z) {
        this.bwg = z;
    }

    public void cP(boolean z) {
        this.bwh = z;
    }

    public void cQ(boolean z) {
        this.bwi = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).bwh == this.bwh && ((a) obj).bwi == this.bwi && ((a) obj).bwg == this.bwg);
    }
}
