package com.baidu.swan.apps.model.a.a;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    protected boolean ceo = false;
    protected boolean cep = false;
    private boolean ceq = false;
    private boolean cer;
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

    public static a agE() {
        a aVar = new a();
        aVar.dY(true);
        aVar.dZ(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void dY(boolean z) {
        this.ceo = z;
    }

    public void dZ(boolean z) {
        this.cep = z;
    }

    public boolean isFixed() {
        return this.cer;
    }

    public void ea(boolean z) {
        this.cer = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void fF(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.f1001top;
    }

    public void fG(int i) {
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
        boolean z2 = this.ceo || this.width >= 0;
        if (this.cep || this.height >= 0) {
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
            return this.left == aVar.left && this.f1001top == aVar.f1001top && this.height == aVar.height && this.width == aVar.width && this.cer == aVar.cer;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.ceq;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.f1001top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.ceo + ", HAuto=" + this.cep + ", fixed=" + this.cer + '}';
    }
}
