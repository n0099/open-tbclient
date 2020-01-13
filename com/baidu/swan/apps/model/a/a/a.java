package com.baidu.swan.apps.model.a.a;
/* loaded from: classes10.dex */
public class a implements Cloneable {
    protected boolean bBg = false;
    protected boolean bBh = false;
    private boolean bBi = false;
    private boolean bBj;
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

    public static a Wg() {
        a aVar = new a();
        aVar.cU(true);
        aVar.cV(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void cU(boolean z) {
        this.bBg = z;
    }

    public void cV(boolean z) {
        this.bBh = z;
    }

    public boolean isFixed() {
        return this.bBj;
    }

    public void cW(boolean z) {
        this.bBj = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void fi(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.top;
    }

    public void fj(int i) {
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
        boolean z2 = this.bBg || this.width >= 0;
        if (this.bBh || this.height >= 0) {
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
            return this.left == aVar.left && this.top == aVar.top && this.height == aVar.height && this.width == aVar.width && this.bBj == aVar.bBj;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.bBi;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.bBg + ", HAuto=" + this.bBh + ", fixed=" + this.bBj + '}';
    }
}
