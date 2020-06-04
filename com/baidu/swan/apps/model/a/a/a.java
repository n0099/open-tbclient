package com.baidu.swan.apps.model.a.a;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    protected boolean coV = false;
    protected boolean coW = false;
    private boolean coX = false;
    private boolean coY;
    protected int height;
    protected int left;

    /* renamed from: top  reason: collision with root package name */
    protected int f1001top;
    protected int width;

    public a() {
    }

    public a(int i, int i2, int i3, int i4) {
        this.left = i;
        this.f1001top = i2;
        this.width = i3;
        this.height = i4;
    }

    public static a ajX() {
        a aVar = new a();
        aVar.ep(true);
        aVar.eq(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void ep(boolean z) {
        this.coV = z;
    }

    public void eq(boolean z) {
        this.coW = z;
    }

    public boolean isFixed() {
        return this.coY;
    }

    public void er(boolean z) {
        this.coY = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void fW(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.f1001top;
    }

    public void fX(int i) {
        this.f1001top = i;
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
        boolean z2 = this.coV || this.width >= 0;
        if (this.coW || this.height >= 0) {
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
            return this.left == aVar.left && this.f1001top == aVar.f1001top && this.height == aVar.height && this.width == aVar.width && this.coY == aVar.coY;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.coX;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.f1001top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.coV + ", HAuto=" + this.coW + ", fixed=" + this.coY + '}';
    }
}
