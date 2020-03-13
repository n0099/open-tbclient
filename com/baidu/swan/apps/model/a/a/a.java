package com.baidu.swan.apps.model.a.a;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    protected boolean bFo = false;
    protected boolean bFp = false;
    private boolean bFq = false;
    private boolean bFr;
    protected int height;
    protected int left;

    /* renamed from: top  reason: collision with root package name */
    protected int f1006top;
    protected int width;

    public a() {
    }

    public a(int i, int i2, int i3, int i4) {
        this.left = i;
        this.f1006top = i2;
        this.width = i3;
        this.height = i4;
    }

    public static a Yw() {
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
        this.bFo = z;
    }

    public void dc(boolean z) {
        this.bFp = z;
    }

    public boolean isFixed() {
        return this.bFr;
    }

    public void dd(boolean z) {
        this.bFr = z;
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
        boolean z2 = this.bFo || this.width >= 0;
        if (this.bFp || this.height >= 0) {
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
            return this.left == aVar.left && this.f1006top == aVar.f1006top && this.height == aVar.height && this.width == aVar.width && this.bFr == aVar.bFr;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.bFq;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.f1006top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.bFo + ", HAuto=" + this.bFp + ", fixed=" + this.bFr + '}';
    }
}
