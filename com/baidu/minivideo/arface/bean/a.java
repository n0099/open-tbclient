package com.baidu.minivideo.arface.bean;
/* loaded from: classes6.dex */
public class a {
    public boolean bCd = true;
    public boolean bCe = true;
    public boolean bCf = true;
    public boolean bCg = true;

    public void cX(boolean z) {
        this.bCd = z;
    }

    public void cY(boolean z) {
        this.bCe = z;
    }

    public void cZ(boolean z) {
        this.bCf = z;
    }

    public void da(boolean z) {
        this.bCg = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).bCf == this.bCf && ((a) obj).bCg == this.bCg && ((a) obj).bCe == this.bCe);
    }
}
