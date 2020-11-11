package com.baidu.minivideo.arface.bean;
/* loaded from: classes15.dex */
public class a {
    public boolean cam = true;
    public boolean can = true;
    public boolean cao = true;
    public boolean cap = true;

    public void dB(boolean z) {
        this.cam = z;
    }

    public void dC(boolean z) {
        this.can = z;
    }

    public void dD(boolean z) {
        this.cao = z;
    }

    public void dE(boolean z) {
        this.cap = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).cao == this.cao && ((a) obj).cap == this.cap && ((a) obj).can == this.can);
    }
}
