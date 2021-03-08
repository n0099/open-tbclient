package com.baidu.ar.seg;
/* loaded from: classes3.dex */
public class a {
    private int height;
    private int orientation;
    private boolean pH;
    private byte[] vQ;
    private int width;

    public a(byte[] bArr, int i, int i2, int i3, boolean z) {
        this.vQ = bArr;
        this.width = i;
        this.height = i2;
        this.orientation = i3;
        this.pH = z;
    }

    public byte[] gc() {
        return this.vQ;
    }

    public int getHeight() {
        return this.height;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isFrontCamera() {
        return this.pH;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
