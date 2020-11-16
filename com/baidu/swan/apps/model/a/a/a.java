package com.baidu.swan.apps.model.a.a;
/* loaded from: classes7.dex */
public class a implements Cloneable {
    private boolean deB;
    protected int height;
    protected int left;
    protected int top;
    protected int width;
    protected boolean dey = false;
    protected boolean dez = false;
    private boolean deA = false;

    public a() {
    }

    public a(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.width = i3;
        this.height = i4;
    }

    public static a aBw() {
        a aVar = new a();
        aVar.fN(true);
        aVar.fO(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void fN(boolean z) {
        this.dey = z;
    }

    public void fO(boolean z) {
        this.dez = z;
    }

    public boolean isFixed() {
        return this.deB;
    }

    public void fP(boolean z) {
        this.deB = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void jw(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.top;
    }

    public void jx(int i) {
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
        boolean z2 = this.dey || this.width >= 0;
        if (this.dez || this.height >= 0) {
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
            return this.left == aVar.left && this.top == aVar.top && this.height == aVar.height && this.width == aVar.width && this.deB == aVar.deB;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.deA;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.dey + ", HAuto=" + this.dez + ", fixed=" + this.deB + '}';
    }
}
