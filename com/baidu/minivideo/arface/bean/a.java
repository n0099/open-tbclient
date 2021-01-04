package com.baidu.minivideo.arface.bean;
/* loaded from: classes6.dex */
public class a {
    public boolean ckH = true;
    public boolean ckI = true;
    public boolean ckJ = true;
    public boolean ckK = true;

    public void ea(boolean z) {
        this.ckH = z;
    }

    public void eb(boolean z) {
        this.ckI = z;
    }

    public void ec(boolean z) {
        this.ckJ = z;
    }

    public void ed(boolean z) {
        this.ckK = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).ckJ == this.ckJ && ((a) obj).ckK == this.ckK && ((a) obj).ckI == this.ckI);
    }
}
