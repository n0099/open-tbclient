package com.baidu.swan.apps.model.a.a;
/* loaded from: classes2.dex */
public class b {
    protected boolean aEw;
    protected boolean aEx;
    private boolean aEy;
    protected int height;
    protected int left;
    protected int top;
    protected int width;

    public b() {
        this.aEw = false;
        this.aEx = false;
    }

    public b(b bVar) {
        this.aEw = false;
        this.aEx = false;
        if (bVar != null) {
            this.left = bVar.left;
            this.top = bVar.top;
            this.width = bVar.width;
            this.height = bVar.height;
            this.aEw = bVar.aEw;
            this.aEx = bVar.aEx;
            this.aEy = bVar.aEy;
        }
    }

    public b(int i, int i2, int i3, int i4) {
        this.aEw = false;
        this.aEx = false;
        this.left = i;
        this.top = i2;
        this.width = i3;
        this.height = i4;
    }

    public static b Hy() {
        b bVar = new b();
        bVar.bB(true);
        bVar.bC(true);
        bVar.setWidth(-1);
        bVar.setHeight(-1);
        return bVar;
    }

    public void bB(boolean z) {
        this.aEw = z;
    }

    public void bC(boolean z) {
        this.aEx = z;
    }

    public boolean isFixed() {
        return this.aEy;
    }

    public void bD(boolean z) {
        this.aEy = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void cN(int i) {
        this.left = i;
    }

    public int Hz() {
        return this.top;
    }

    public void cO(int i) {
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
        boolean z2 = this.aEw || this.width >= 0;
        if (this.aEx || this.height >= 0) {
            z = true;
        }
        return z2 & z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.left == bVar.left && this.top == bVar.top && this.height == bVar.height && this.width == bVar.width && this.aEy == bVar.aEy;
        }
        return false;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.aEw + ", HAuto=" + this.aEx + ", fixed=" + this.aEy + '}';
    }
}
