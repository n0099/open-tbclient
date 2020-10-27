package com.baidu.swan.apps.model.a.a;
/* loaded from: classes10.dex */
public class a implements Cloneable {
    protected boolean dai = false;
    protected boolean daj = false;
    private boolean dak = false;
    private boolean dal;
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

    public static a azE() {
        a aVar = new a();
        aVar.fB(true);
        aVar.fC(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void fB(boolean z) {
        this.dai = z;
    }

    public void fC(boolean z) {
        this.daj = z;
    }

    public boolean isFixed() {
        return this.dal;
    }

    public void fD(boolean z) {
        this.dal = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void jq(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.top;
    }

    public void jr(int i) {
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
        boolean z2 = this.dai || this.width >= 0;
        if (this.daj || this.height >= 0) {
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
            return this.left == aVar.left && this.top == aVar.top && this.height == aVar.height && this.width == aVar.width && this.dal == aVar.dal;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.dak;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.dai + ", HAuto=" + this.daj + ", fixed=" + this.dal + '}';
    }
}
