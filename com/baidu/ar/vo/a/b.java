package com.baidu.ar.vo.a;
/* loaded from: classes11.dex */
public class b {
    private String id;
    private int xN;
    private String xO;
    private int xQ;
    private String xR;
    private int xP = 1000;
    private boolean xS = true;

    public void Q(int i) {
        this.xN = i;
    }

    public void R(int i) {
        this.xP = i;
    }

    public void S(int i) {
        this.xQ = i;
    }

    public void X(boolean z) {
        this.xS = z;
    }

    public void aU(String str) {
        this.xO = str;
    }

    public void aV(String str) {
        this.xR = str;
    }

    public String getId() {
        return this.id;
    }

    public int hd() {
        return this.xN;
    }

    public String he() {
        return this.xO;
    }

    public int hf() {
        return this.xP;
    }

    public int hg() {
        return this.xQ;
    }

    public boolean hh() {
        return this.xS;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String toString() {
        return "SlamModel{id='" + this.id + "', placeType=" + this.xN + ", position='" + this.xO + "', distance=" + this.xP + ", pitchAngle=" + this.xQ + ", rotation='" + this.xR + "', mImmediatelyPlaceModel=" + this.xS + '}';
    }
}
