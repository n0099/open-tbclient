package com.baidu.swan.apps.model.a.a;
/* loaded from: classes25.dex */
public class a implements Cloneable {
    protected boolean dlw = false;
    protected boolean dlx = false;
    private boolean dly = false;
    private boolean dlz;
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

    public static a aEF() {
        a aVar = new a();
        aVar.gc(true);
        aVar.gd(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void gc(boolean z) {
        this.dlw = z;
    }

    public void gd(boolean z) {
        this.dlx = z;
    }

    public boolean isFixed() {
        return this.dlz;
    }

    public void ge(boolean z) {
        this.dlz = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void jU(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.top;
    }

    public void jV(int i) {
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
        boolean z2 = this.dlw || this.width >= 0;
        if (this.dlx || this.height >= 0) {
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
            return this.left == aVar.left && this.top == aVar.top && this.height == aVar.height && this.width == aVar.width && this.dlz == aVar.dlz;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.dly;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.dlw + ", HAuto=" + this.dlx + ", fixed=" + this.dlz + '}';
    }
}
