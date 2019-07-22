package com.baidu.swan.apps.model.a.a;
/* loaded from: classes2.dex */
public class b {
    protected boolean aDY;
    protected boolean aDZ;
    private boolean aEa;
    protected int height;
    protected int left;
    protected int top;
    protected int width;

    public b() {
        this.aDY = false;
        this.aDZ = false;
    }

    public b(b bVar) {
        this.aDY = false;
        this.aDZ = false;
        if (bVar != null) {
            this.left = bVar.left;
            this.top = bVar.top;
            this.width = bVar.width;
            this.height = bVar.height;
            this.aDY = bVar.aDY;
            this.aDZ = bVar.aDZ;
            this.aEa = bVar.aEa;
        }
    }

    public b(int i, int i2, int i3, int i4) {
        this.aDY = false;
        this.aDZ = false;
        this.left = i;
        this.top = i2;
        this.width = i3;
        this.height = i4;
    }

    public static b Hu() {
        b bVar = new b();
        bVar.bB(true);
        bVar.bC(true);
        bVar.setWidth(-1);
        bVar.setHeight(-1);
        return bVar;
    }

    public void bB(boolean z) {
        this.aDY = z;
    }

    public void bC(boolean z) {
        this.aDZ = z;
    }

    public boolean isFixed() {
        return this.aEa;
    }

    public void bD(boolean z) {
        this.aEa = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void cM(int i) {
        this.left = i;
    }

    public int Hv() {
        return this.top;
    }

    public void cN(int i) {
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
        boolean z2 = this.aDY || this.width >= 0;
        if (this.aDZ || this.height >= 0) {
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
            return this.left == bVar.left && this.top == bVar.top && this.height == bVar.height && this.width == bVar.width && this.aEa == bVar.aEa;
        }
        return false;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.aDY + ", HAuto=" + this.aDZ + ", fixed=" + this.aEa + '}';
    }
}
