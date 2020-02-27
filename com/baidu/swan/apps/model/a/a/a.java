package com.baidu.swan.apps.model.a.a;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    protected boolean bFm = false;
    protected boolean bFn = false;
    private boolean bFo = false;
    private boolean bFp;
    protected int height;
    protected int left;

    /* renamed from: top  reason: collision with root package name */
    protected int f1007top;
    protected int width;

    public a() {
    }

    public a(int i, int i2, int i3, int i4) {
        this.left = i;
        this.f1007top = i2;
        this.width = i3;
        this.height = i4;
    }

    public static a Yu() {
        a aVar = new a();
        aVar.db(true);
        aVar.dc(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void db(boolean z) {
        this.bFm = z;
    }

    public void dc(boolean z) {
        this.bFn = z;
    }

    public boolean isFixed() {
        return this.bFp;
    }

    public void dd(boolean z) {
        this.bFp = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void fy(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.f1007top;
    }

    public void fz(int i) {
        this.f1007top = i;
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
        boolean z2 = this.bFm || this.width >= 0;
        if (this.bFn || this.height >= 0) {
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
            return this.left == aVar.left && this.f1007top == aVar.f1007top && this.height == aVar.height && this.width == aVar.width && this.bFp == aVar.bFp;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.bFo;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.f1007top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.bFm + ", HAuto=" + this.bFn + ", fixed=" + this.bFp + '}';
    }
}
