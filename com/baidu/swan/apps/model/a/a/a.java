package com.baidu.swan.apps.model.a.a;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    private boolean bFC;
    protected int height;
    protected int left;

    /* renamed from: top  reason: collision with root package name */
    protected int f1006top;
    protected int width;
    protected boolean bFz = false;
    protected boolean bFA = false;
    private boolean bFB = false;

    public a() {
    }

    public a(int i, int i2, int i3, int i4) {
        this.left = i;
        this.f1006top = i2;
        this.width = i3;
        this.height = i4;
    }

    public static a Yz() {
        a aVar = new a();
        aVar.dc(true);
        aVar.dd(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void dc(boolean z) {
        this.bFz = z;
    }

    public void dd(boolean z) {
        this.bFA = z;
    }

    public boolean isFixed() {
        return this.bFC;
    }

    public void de(boolean z) {
        this.bFC = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void fy(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.f1006top;
    }

    public void fz(int i) {
        this.f1006top = i;
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
        boolean z2 = this.bFz || this.width >= 0;
        if (this.bFA || this.height >= 0) {
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
            return this.left == aVar.left && this.f1006top == aVar.f1006top && this.height == aVar.height && this.width == aVar.width && this.bFC == aVar.bFC;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.bFB;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.f1006top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.bFz + ", HAuto=" + this.bFA + ", fixed=" + this.bFC + '}';
    }
}
