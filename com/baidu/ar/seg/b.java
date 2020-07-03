package com.baidu.ar.seg;
/* loaded from: classes3.dex */
public class b {
    private int height;
    private boolean nZ;
    private int orientation;
    private byte[] uy;
    private int width;

    public b(byte[] bArr, int i, int i2, int i3, boolean z) {
        this.uy = bArr;
        this.width = i;
        this.height = i2;
        this.orientation = i3;
        this.nZ = z;
    }

    public byte[] eO() {
        return this.uy;
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
        return this.nZ;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
