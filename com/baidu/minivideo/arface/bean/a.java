package com.baidu.minivideo.arface.bean;
/* loaded from: classes6.dex */
public class a {
    public boolean bCg = true;
    public boolean bCh = true;
    public boolean bCi = true;
    public boolean bCj = true;

    public void cY(boolean z) {
        this.bCg = z;
    }

    public void cZ(boolean z) {
        this.bCh = z;
    }

    public void da(boolean z) {
        this.bCi = z;
    }

    public void db(boolean z) {
        this.bCj = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).bCi == this.bCi && ((a) obj).bCj == this.bCj && ((a) obj).bCh == this.bCh);
    }
}
