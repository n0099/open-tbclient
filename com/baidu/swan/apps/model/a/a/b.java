package com.baidu.swan.apps.model.a.a;
/* loaded from: classes2.dex */
public class b {
    protected boolean aBK;
    protected boolean aBL;
    private boolean aBM;
    protected int height;
    protected int left;
    protected int top;
    protected int width;

    public b() {
        this.aBK = false;
        this.aBL = false;
    }

    public b(b bVar) {
        this.aBK = false;
        this.aBL = false;
        if (bVar != null) {
            this.left = bVar.left;
            this.top = bVar.top;
            this.width = bVar.width;
            this.height = bVar.height;
            this.aBK = bVar.aBK;
            this.aBL = bVar.aBL;
            this.aBM = bVar.aBM;
        }
    }

    public b(int i, int i2, int i3, int i4) {
        this.aBK = false;
        this.aBL = false;
        this.left = i;
        this.top = i2;
        this.width = i3;
        this.height = i4;
    }

    public static b EM() {
        b bVar = new b();
        bVar.bq(true);
        bVar.br(true);
        bVar.setWidth(-1);
        bVar.setHeight(-1);
        return bVar;
    }

    public void bq(boolean z) {
        this.aBK = z;
    }

    public void br(boolean z) {
        this.aBL = z;
    }

    public boolean isFixed() {
        return this.aBM;
    }

    public void bs(boolean z) {
        this.aBM = z;
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
        boolean z2 = this.aBK || this.width >= 0;
        if (this.aBL || this.height >= 0) {
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
            return this.left == bVar.left && this.top == bVar.top && this.height == bVar.height && this.width == bVar.width && this.aBM == bVar.aBM;
        }
        return false;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.aBK + ", HAuto=" + this.aBL + ", fixed=" + this.aBM + '}';
    }
}
