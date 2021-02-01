package com.baidu.minivideo.arface.bean;
/* loaded from: classes3.dex */
public class a {
    public boolean cke = true;
    public boolean ckf = true;
    public boolean ckg = true;
    public boolean ckh = true;

    public void ee(boolean z) {
        this.cke = z;
    }

    public void ef(boolean z) {
        this.ckf = z;
    }

    public void eg(boolean z) {
        this.ckg = z;
    }

    public void eh(boolean z) {
        this.ckh = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).ckg == this.ckg && ((a) obj).ckh == this.ckh && ((a) obj).ckf == this.ckf);
    }
}
