package com.baidu.minivideo.arface.bean;
/* loaded from: classes8.dex */
public class a {
    public boolean cec = true;
    public boolean ced = true;
    public boolean cee = true;
    public boolean cef = true;

    public void dT(boolean z) {
        this.cec = z;
    }

    public void dU(boolean z) {
        this.ced = z;
    }

    public void dV(boolean z) {
        this.cee = z;
    }

    public void dW(boolean z) {
        this.cef = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).cee == this.cee && ((a) obj).cef == this.cef && ((a) obj).ced == this.ced);
    }
}
