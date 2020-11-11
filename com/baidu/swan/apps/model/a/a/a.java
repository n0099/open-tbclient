package com.baidu.swan.apps.model.a.a;
/* loaded from: classes10.dex */
public class a implements Cloneable {
    protected boolean dgf = false;
    protected boolean dgg = false;
    private boolean dgh = false;
    private boolean dgi;
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

    public static a aCe() {
        a aVar = new a();
        aVar.fK(true);
        aVar.fL(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void fK(boolean z) {
        this.dgf = z;
    }

    public void fL(boolean z) {
        this.dgg = z;
    }

    public boolean isFixed() {
        return this.dgi;
    }

    public void fM(boolean z) {
        this.dgi = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void jA(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.top;
    }

    public void jB(int i) {
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
        boolean z2 = this.dgf || this.width >= 0;
        if (this.dgg || this.height >= 0) {
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
            return this.left == aVar.left && this.top == aVar.top && this.height == aVar.height && this.width == aVar.width && this.dgi == aVar.dgi;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.dgh;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.dgf + ", HAuto=" + this.dgg + ", fixed=" + this.dgi + '}';
    }
}
