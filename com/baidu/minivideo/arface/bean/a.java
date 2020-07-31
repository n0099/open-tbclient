package com.baidu.minivideo.arface.bean;
/* loaded from: classes6.dex */
public class a {
    public boolean bwu = true;
    public boolean bwv = true;
    public boolean bww = true;
    public boolean bwx = true;

    public void cP(boolean z) {
        this.bwu = z;
    }

    public void cQ(boolean z) {
        this.bwv = z;
    }

    public void cR(boolean z) {
        this.bww = z;
    }

    public void cS(boolean z) {
        this.bwx = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).bww == this.bww && ((a) obj).bwx == this.bwx && ((a) obj).bwv == this.bwv);
    }
}
