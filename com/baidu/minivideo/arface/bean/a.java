package com.baidu.minivideo.arface.bean;
/* loaded from: classes15.dex */
public class a {
    public boolean bUC = true;
    public boolean bUD = true;
    public boolean bUE = true;
    public boolean bUF = true;

    public void du(boolean z) {
        this.bUC = z;
    }

    public void dv(boolean z) {
        this.bUD = z;
    }

    public void dw(boolean z) {
        this.bUE = z;
    }

    public void dx(boolean z) {
        this.bUF = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).bUE == this.bUE && ((a) obj).bUF == this.bUF && ((a) obj).bUD == this.bUD);
    }
}
