package com.baidu.minivideo.arface.bean;
/* loaded from: classes3.dex */
public class a {
    public boolean bjC = true;
    public boolean bjD = true;
    public boolean bjE = true;
    public boolean bjF = true;

    public void cw(boolean z) {
        this.bjC = z;
    }

    public void cx(boolean z) {
        this.bjD = z;
    }

    public void cy(boolean z) {
        this.bjE = z;
    }

    public void cz(boolean z) {
        this.bjF = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).bjE == this.bjE && ((a) obj).bjF == this.bjF && ((a) obj).bjD == this.bjD);
    }
}
