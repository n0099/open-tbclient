package com.baidu.swan.apps.model.a.a;
/* loaded from: classes8.dex */
public class a implements Cloneable {
    protected boolean dpu = false;
    protected boolean dpv = false;
    private boolean dpw = false;
    private boolean dpx;
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

    public static a aCF() {
        a aVar = new a();
        aVar.gj(true);
        aVar.gk(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void gj(boolean z) {
        this.dpu = z;
    }

    public void gk(boolean z) {
        this.dpv = z;
    }

    public boolean isFixed() {
        return this.dpx;
    }

    public void gl(boolean z) {
        this.dpx = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void in(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.top;
    }

    public void io(int i) {
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
        boolean z2 = this.dpu || this.width >= 0;
        if (this.dpv || this.height >= 0) {
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
            return this.left == aVar.left && this.top == aVar.top && this.height == aVar.height && this.width == aVar.width && this.dpx == aVar.dpx;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.dpw;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.dpu + ", HAuto=" + this.dpv + ", fixed=" + this.dpx + '}';
    }
}
