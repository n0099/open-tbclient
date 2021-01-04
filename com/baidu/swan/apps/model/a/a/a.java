package com.baidu.swan.apps.model.a.a;
/* loaded from: classes9.dex */
public class a implements Cloneable {
    protected boolean dqv = false;
    protected boolean dqw = false;
    private boolean dqx = false;
    private boolean dqy;
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

    public static a aFY() {
        a aVar = new a();
        aVar.gl(true);
        aVar.gm(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void gl(boolean z) {
        this.dqv = z;
    }

    public void gm(boolean z) {
        this.dqw = z;
    }

    public boolean isFixed() {
        return this.dqy;
    }

    public void gn(boolean z) {
        this.dqy = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void jP(int i) {
        this.left = i;
    }

    public int aFZ() {
        return this.top;
    }

    public void jQ(int i) {
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
        boolean z2 = this.dqv || this.width >= 0;
        if (this.dqw || this.height >= 0) {
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
            return this.left == aVar.left && this.top == aVar.top && this.height == aVar.height && this.width == aVar.width && this.dqy == aVar.dqy;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.dqx;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.dqv + ", HAuto=" + this.dqw + ", fixed=" + this.dqy + '}';
    }
}
