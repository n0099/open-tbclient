package com.baidu.swan.apps.model.a.a;
/* loaded from: classes2.dex */
public class b {
    protected boolean aXL;
    protected boolean aXM;
    private boolean aXN;
    protected int height;
    protected int left;
    protected int top;
    protected int width;

    public b() {
        this.aXL = false;
        this.aXM = false;
    }

    public b(b bVar) {
        this.aXL = false;
        this.aXM = false;
        if (bVar != null) {
            this.left = bVar.left;
            this.top = bVar.top;
            this.width = bVar.width;
            this.height = bVar.height;
            this.aXL = bVar.aXL;
            this.aXM = bVar.aXM;
            this.aXN = bVar.aXN;
        }
    }

    public b(int i, int i2, int i3, int i4) {
        this.aXL = false;
        this.aXM = false;
        this.left = i;
        this.top = i2;
        this.width = i3;
        this.height = i4;
    }

    public static b Ms() {
        b bVar = new b();
        bVar.bT(true);
        bVar.bU(true);
        bVar.setWidth(-1);
        bVar.setHeight(-1);
        return bVar;
    }

    public void bT(boolean z) {
        this.aXL = z;
    }

    public void bU(boolean z) {
        this.aXM = z;
    }

    public boolean isFixed() {
        return this.aXN;
    }

    public void bV(boolean z) {
        this.aXN = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void dI(int i) {
        this.left = i;
    }

    public int Mt() {
        return this.top;
    }

    public void dJ(int i) {
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
        boolean z2 = this.aXL || this.width >= 0;
        if (this.aXM || this.height >= 0) {
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
            return this.left == bVar.left && this.top == bVar.top && this.height == bVar.height && this.width == bVar.width && this.aXN == bVar.aXN;
        }
        return false;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.aXL + ", HAuto=" + this.aXM + ", fixed=" + this.aXN + '}';
    }
}
