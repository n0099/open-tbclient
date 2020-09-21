package com.baidu.swan.apps.model.a.a;
/* loaded from: classes3.dex */
public class a implements Cloneable {
    protected boolean cFI = false;
    protected boolean cFJ = false;
    private boolean cFK = false;
    private boolean cFL;
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

    public static a auZ() {
        a aVar = new a();
        aVar.eS(true);
        aVar.eT(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void eS(boolean z) {
        this.cFI = z;
    }

    public void eT(boolean z) {
        this.cFJ = z;
    }

    public boolean isFixed() {
        return this.cFL;
    }

    public void eU(boolean z) {
        this.cFL = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void iI(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.top;
    }

    public void iJ(int i) {
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
        boolean z2 = this.cFI || this.width >= 0;
        if (this.cFJ || this.height >= 0) {
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
            return this.left == aVar.left && this.top == aVar.top && this.height == aVar.height && this.width == aVar.width && this.cFL == aVar.cFL;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.cFK;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.cFI + ", HAuto=" + this.cFJ + ", fixed=" + this.cFL + '}';
    }
}
