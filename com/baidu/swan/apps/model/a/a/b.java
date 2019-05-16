package com.baidu.swan.apps.model.a.a;
/* loaded from: classes2.dex */
public class b {
    protected boolean aDq;
    protected boolean aDr;
    private boolean aDs;
    protected int height;
    protected int left;
    protected int top;
    protected int width;

    public b() {
        this.aDq = false;
        this.aDr = false;
    }

    public b(b bVar) {
        this.aDq = false;
        this.aDr = false;
        if (bVar != null) {
            this.left = bVar.left;
            this.top = bVar.top;
            this.width = bVar.width;
            this.height = bVar.height;
            this.aDq = bVar.aDq;
            this.aDr = bVar.aDr;
            this.aDs = bVar.aDs;
        }
    }

    public b(int i, int i2, int i3, int i4) {
        this.aDq = false;
        this.aDr = false;
        this.left = i;
        this.top = i2;
        this.width = i3;
        this.height = i4;
    }

    public static b GK() {
        b bVar = new b();
        bVar.by(true);
        bVar.bz(true);
        bVar.setWidth(-1);
        bVar.setHeight(-1);
        return bVar;
    }

    public void by(boolean z) {
        this.aDq = z;
    }

    public void bz(boolean z) {
        this.aDr = z;
    }

    public boolean isFixed() {
        return this.aDs;
    }

    public void bA(boolean z) {
        this.aDs = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void setLeft(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.top;
    }

    public void setTop(int i) {
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
        boolean z2 = this.aDq || this.width >= 0;
        if (this.aDr || this.height >= 0) {
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
            return this.left == bVar.left && this.top == bVar.top && this.height == bVar.height && this.width == bVar.width && this.aDs == bVar.aDs;
        }
        return false;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.aDq + ", HAuto=" + this.aDr + ", fixed=" + this.aDs + '}';
    }
}
