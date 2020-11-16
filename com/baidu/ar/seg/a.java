package com.baidu.ar.seg;
/* loaded from: classes12.dex */
public class a {
    private int height;
    private int orientation;
    private boolean pr;
    private byte[] vc;
    private int width;

    public a(byte[] bArr, int i, int i2, int i3, boolean z) {
        this.vc = bArr;
        this.width = i;
        this.height = i2;
        this.orientation = i3;
        this.pr = z;
    }

    public byte[] gc() {
        return this.vc;
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
        return this.pr;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
