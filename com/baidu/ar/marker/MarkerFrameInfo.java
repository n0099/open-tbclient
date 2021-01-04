package com.baidu.ar.marker;
/* loaded from: classes6.dex */
public class MarkerFrameInfo {
    private int tc;
    private int td;
    private double[] te;
    private float[] tf;
    private float[] tg;
    private int th;
    private int ti;
    private byte[] tj;
    private float[] tk;
    private float tl;

    public float[] getDistort() {
        return this.tg;
    }

    public int getFps() {
        return this.ti;
    }

    public byte[] getImage() {
        return this.tj;
    }

    public int getInputHeight() {
        return this.td;
    }

    public int getInputWidth() {
        return this.tc;
    }

    public float[] getIntrinsics() {
        return this.tf;
    }

    public double[] getMagnet() {
        return this.te;
    }

    public float[] getPoseMat() {
        return this.tk;
    }

    public float getScaleY() {
        return this.tl;
    }

    public int getTrackingState() {
        return this.th;
    }

    public void setDistort(float[] fArr) {
        this.tg = fArr;
    }

    public void setFps(int i) {
        this.ti = i;
    }

    public void setImage(byte[] bArr) {
        this.tj = bArr;
    }

    public void setInputHeight(int i) {
        this.td = i;
    }

    public void setInputWidth(int i) {
        this.tc = i;
    }

    public void setIntrinsics(float[] fArr) {
        this.tf = fArr;
    }

    public void setMagnet(double[] dArr) {
        this.te = dArr;
    }

    public void setPoseMat(float[] fArr) {
        this.tk = fArr;
    }

    public void setScaleY(float f) {
        this.tl = f;
    }

    public void setTrackingState(int i) {
        this.th = i;
    }
}
