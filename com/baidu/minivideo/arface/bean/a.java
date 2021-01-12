package com.baidu.minivideo.arface.bean;
/* loaded from: classes5.dex */
public class a {
    public boolean cfU = true;
    public boolean cfV = true;
    public boolean cfW = true;
    public boolean cfX = true;

    public void dW(boolean z) {
        this.cfU = z;
    }

    public void dX(boolean z) {
        this.cfV = z;
    }

    public void dY(boolean z) {
        this.cfW = z;
    }

    public void dZ(boolean z) {
        this.cfX = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).cfW == this.cfW && ((a) obj).cfX == this.cfX && ((a) obj).cfV == this.cfV);
    }
}
