package com.baidu.swan.apps.model.a.a;
/* loaded from: classes2.dex */
public class b {
    protected boolean aBH;
    protected boolean aBI;
    private boolean aBJ;
    protected int height;
    protected int left;
    protected int top;
    protected int width;

    public b() {
        this.aBH = false;
        this.aBI = false;
    }

    public b(b bVar) {
        this.aBH = false;
        this.aBI = false;
        if (bVar != null) {
            this.left = bVar.left;
            this.top = bVar.top;
            this.width = bVar.width;
            this.height = bVar.height;
            this.aBH = bVar.aBH;
            this.aBI = bVar.aBI;
            this.aBJ = bVar.aBJ;
        }
    }

    public b(int i, int i2, int i3, int i4) {
        this.aBH = false;
        this.aBI = false;
        this.left = i;
        this.top = i2;
        this.width = i3;
        this.height = i4;
    }

    public static b EO() {
        b bVar = new b();
        bVar.bq(true);
        bVar.br(true);
        bVar.setWidth(-1);
        bVar.setHeight(-1);
        return bVar;
    }

    public void bq(boolean z) {
        this.aBH = z;
    }

    public void br(boolean z) {
        this.aBI = z;
    }

    public boolean isFixed() {
        return this.aBJ;
    }

    public void bs(boolean z) {
        this.aBJ = z;
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
        boolean z2 = this.aBH || this.width >= 0;
        if (this.aBI || this.height >= 0) {
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
            return this.left == bVar.left && this.top == bVar.top && this.height == bVar.height && this.width == bVar.width && this.aBJ == bVar.aBJ;
        }
        return false;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.aBH + ", HAuto=" + this.aBI + ", fixed=" + this.aBJ + '}';
    }
}
