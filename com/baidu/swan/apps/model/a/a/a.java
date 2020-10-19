package com.baidu.swan.apps.model.a.a;
/* loaded from: classes10.dex */
public class a implements Cloneable {
    protected boolean cRM = false;
    protected boolean cRN = false;
    private boolean cRO = false;
    private boolean cRP;
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

    public static a axK() {
        a aVar = new a();
        aVar.fo(true);
        aVar.fp(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void fo(boolean z) {
        this.cRM = z;
    }

    public void fp(boolean z) {
        this.cRN = z;
    }

    public boolean isFixed() {
        return this.cRP;
    }

    public void fq(boolean z) {
        this.cRP = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void jf(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.top;
    }

    public void jg(int i) {
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
        boolean z2 = this.cRM || this.width >= 0;
        if (this.cRN || this.height >= 0) {
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
            return this.left == aVar.left && this.top == aVar.top && this.height == aVar.height && this.width == aVar.width && this.cRP == aVar.cRP;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.cRO;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.cRM + ", HAuto=" + this.cRN + ", fixed=" + this.cRP + '}';
    }
}
