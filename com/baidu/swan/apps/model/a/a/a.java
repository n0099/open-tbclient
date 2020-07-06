package com.baidu.swan.apps.model.a.a;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    protected boolean ctJ = false;
    protected boolean ctK = false;
    private boolean ctL = false;
    private boolean ctM;
    protected int height;
    protected int left;

    /* renamed from: top  reason: collision with root package name */
    protected int f1005top;
    protected int width;

    public a() {
    }

    public a(int i, int i2, int i3, int i4) {
        this.left = i;
        this.f1005top = i2;
        this.width = i3;
        this.height = i4;
    }

    public static a ald() {
        a aVar = new a();
        aVar.eu(true);
        aVar.ev(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void eu(boolean z) {
        this.ctJ = z;
    }

    public void ev(boolean z) {
        this.ctK = z;
    }

    public boolean isFixed() {
        return this.ctM;
    }

    public void ew(boolean z) {
        this.ctM = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void gh(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.f1005top;
    }

    public void gi(int i) {
        this.f1005top = i;
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
        boolean z2 = this.ctJ || this.width >= 0;
        if (this.ctK || this.height >= 0) {
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
            return this.left == aVar.left && this.f1005top == aVar.f1005top && this.height == aVar.height && this.width == aVar.width && this.ctM == aVar.ctM;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.ctL;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.f1005top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.ctJ + ", HAuto=" + this.ctK + ", fixed=" + this.ctM + '}';
    }
}
