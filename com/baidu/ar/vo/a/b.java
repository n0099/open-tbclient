package com.baidu.ar.vo.a;
/* loaded from: classes3.dex */
public class b {
    private String id;
    private int yC;
    private String yD;
    private int yF;
    private String yG;
    private int yE = 1000;
    private boolean yH = true;

    public void T(int i) {
        this.yC = i;
    }

    public void U(int i) {
        this.yE = i;
    }

    public void V(int i) {
        this.yF = i;
    }

    public void V(boolean z) {
        this.yH = z;
    }

    public void aX(String str) {
        this.yD = str;
    }

    public void aY(String str) {
        this.yG = str;
    }

    public String getId() {
        return this.id;
    }

    public int hd() {
        return this.yC;
    }

    public String he() {
        return this.yD;
    }

    public int hf() {
        return this.yE;
    }

    public int hg() {
        return this.yF;
    }

    public boolean hh() {
        return this.yH;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String toString() {
        return "SlamModel{id='" + this.id + "', placeType=" + this.yC + ", position='" + this.yD + "', distance=" + this.yE + ", pitchAngle=" + this.yF + ", rotation='" + this.yG + "', mImmediatelyPlaceModel=" + this.yH + '}';
    }
}
