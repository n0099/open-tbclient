package com.baidu.swan.apps.model.a.a;
/* loaded from: classes7.dex */
public class a implements Cloneable {
    protected boolean cvL = false;
    protected boolean cvM = false;
    private boolean cvN = false;
    private boolean cvO;
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

    public static a amu() {
        a aVar = new a();
        aVar.eC(true);
        aVar.eD(true);
        aVar.setWidth(-1);
        aVar.setHeight(-1);
        return aVar;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void eC(boolean z) {
        this.cvL = z;
    }

    public void eD(boolean z) {
        this.cvM = z;
    }

    public boolean isFixed() {
        return this.cvO;
    }

    public void eE(boolean z) {
        this.cvO = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void gs(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.top;
    }

    public void gt(int i) {
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
        boolean z2 = this.cvL || this.width >= 0;
        if (this.cvM || this.height >= 0) {
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
            return this.left == aVar.left && this.top == aVar.top && this.height == aVar.height && this.width == aVar.width && this.cvO == aVar.cvO;
        }
        return false;
    }

    public boolean a(a aVar) {
        return !equals(aVar) || this.cvN;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.cvL + ", HAuto=" + this.cvM + ", fixed=" + this.cvO + '}';
    }
}
