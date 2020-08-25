package com.baidu.swan.apps.model.a.a;
/* loaded from: classes8.dex */
public class a implements Cloneable {
    protected boolean cDE = false;
    protected boolean cDF = false;
    private boolean cDG = false;
    private boolean cDH;
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

    public static a auq() {
        a aVar = new a();
        aVar.eT(true);
        aVar.eU(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void eT(boolean z) {
        this.cDE = z;
    }

    public void eU(boolean z) {
        this.cDF = z;
    }

    public boolean isFixed() {
        return this.cDH;
    }

    public void eV(boolean z) {
        this.cDH = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void iy(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.top;
    }

    public void iz(int i) {
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
        boolean z2 = this.cDE || this.width >= 0;
        if (this.cDF || this.height >= 0) {
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
            return this.left == aVar.left && this.top == aVar.top && this.height == aVar.height && this.width == aVar.width && this.cDH == aVar.cDH;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.cDG;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.cDE + ", HAuto=" + this.cDF + ", fixed=" + this.cDH + '}';
    }
}
