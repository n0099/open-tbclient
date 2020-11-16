package com.baidu.minivideo.arface.bean;
/* loaded from: classes14.dex */
public class a {
    public boolean bYB = true;
    public boolean bYC = true;
    public boolean bYD = true;
    public boolean bYE = true;

    public void dD(boolean z) {
        this.bYB = z;
    }

    public void dE(boolean z) {
        this.bYC = z;
    }

    public void dF(boolean z) {
        this.bYD = z;
    }

    public void dG(boolean z) {
        this.bYE = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).bYD == this.bYD && ((a) obj).bYE == this.bYE && ((a) obj).bYC == this.bYC);
    }
}
