package com.baidu.swan.apps.model.a.a;
/* loaded from: classes8.dex */
public class a implements Cloneable {
    protected boolean dlF = false;
    protected boolean dlG = false;
    private boolean dlH = false;
    private boolean dlI;
    protected int height;
    protected int left;
    protected int top;
    protected int width;

    public a() {
    }

    public a(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.width = i3;
        this.height = i4;
    }

    public static a aCf() {
        a aVar = new a();
        aVar.gh(true);
        aVar.gi(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void gh(boolean z) {
        this.dlF = z;
    }

    public void gi(boolean z) {
        this.dlG = z;
    }

    public boolean isFixed() {
        return this.dlI;
    }

    public void gj(boolean z) {
        this.dlI = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void ij(int i) {
        this.left = i;
    }

    public int aCg() {
        return this.top;
    }

    public void ik(int i) {
        this.top = i;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public boolean isValid() {
        boolean z = false;
        boolean z2 = this.dlF || this.width >= 0;
        if (this.dlG || this.height >= 0) {
            z = true;
        }
        return z2 & z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.left == aVar.left && this.top == aVar.top && this.height == aVar.height && this.width == aVar.width && this.dlI == aVar.dlI;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.dlH;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.dlF + ", HAuto=" + this.dlG + ", fixed=" + this.dlI + '}';
    }
}
