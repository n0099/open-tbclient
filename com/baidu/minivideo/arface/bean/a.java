package com.baidu.minivideo.arface.bean;
/* loaded from: classes5.dex */
public class a {
    public boolean clE = true;
    public boolean clF = true;
    public boolean clG = true;
    public boolean clH = true;

    public void ee(boolean z) {
        this.clE = z;
    }

    public void ef(boolean z) {
        this.clF = z;
    }

    public void eg(boolean z) {
        this.clG = z;
    }

    public void eh(boolean z) {
        this.clH = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).clG == this.clG && ((a) obj).clH == this.clH && ((a) obj).clF == this.clF);
    }
}
