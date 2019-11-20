package com.baidu.swan.apps.model.a.a;
/* loaded from: classes2.dex */
public class b {
    protected boolean aXt;
    protected boolean aXu;
    private boolean aXv;
    protected int height;
    protected int left;
    protected int top;
    protected int width;

    public b() {
        this.aXt = false;
        this.aXu = false;
    }

    public b(b bVar) {
        this.aXt = false;
        this.aXu = false;
        if (bVar != null) {
            this.left = bVar.left;
            this.top = bVar.top;
            this.width = bVar.width;
            this.height = bVar.height;
            this.aXt = bVar.aXt;
            this.aXu = bVar.aXu;
            this.aXv = bVar.aXv;
        }
    }

    public b(int i, int i2, int i3, int i4) {
        this.aXt = false;
        this.aXu = false;
        this.left = i;
        this.top = i2;
        this.width = i3;
        this.height = i4;
    }

    public static b Mt() {
        b bVar = new b();
        bVar.bT(true);
        bVar.bU(true);
        bVar.setWidth(-1);
        bVar.setHeight(-1);
        return bVar;
    }

    public void bT(boolean z) {
        this.aXt = z;
    }

    public void bU(boolean z) {
        this.aXu = z;
    }

    public boolean isFixed() {
        return this.aXv;
    }

    public void bV(boolean z) {
        this.aXv = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void dI(int i) {
        this.left = i;
    }

    public int Mu() {
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
        boolean z2 = this.aXt || this.width >= 0;
        if (this.aXu || this.height >= 0) {
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
            return this.left == bVar.left && this.top == bVar.top && this.height == bVar.height && this.width == bVar.width && this.aXv == bVar.aXv;
        }
        return false;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.aXt + ", HAuto=" + this.aXu + ", fixed=" + this.aXv + '}';
    }
}
