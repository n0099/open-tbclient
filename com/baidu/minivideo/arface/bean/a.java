package com.baidu.minivideo.arface.bean;
/* loaded from: classes3.dex */
public class a {
    public boolean bjH = true;
    public boolean bjI = true;
    public boolean bjJ = true;
    public boolean bjK = true;

    public void cw(boolean z) {
        this.bjH = z;
    }

    public void cx(boolean z) {
        this.bjI = z;
    }

    public void cy(boolean z) {
        this.bjJ = z;
    }

    public void cz(boolean z) {
        this.bjK = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).bjJ == this.bjJ && ((a) obj).bjK == this.bjK && ((a) obj).bjI == this.bjI);
    }
}
