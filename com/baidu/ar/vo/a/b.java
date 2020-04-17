package com.baidu.ar.vo.a;
/* loaded from: classes3.dex */
public class b {
    private String id;
    private int wO;
    private String wP;
    private int wR;
    private String wS;
    private int wQ = 1000;
    private boolean wT = true;

    public void I(int i) {
        this.wO = i;
    }

    public void J(int i) {
        this.wQ = i;
    }

    public void K(int i) {
        this.wR = i;
    }

    public void W(boolean z) {
        this.wT = z;
    }

    public void aP(String str) {
        this.wP = str;
    }

    public void aQ(String str) {
        this.wS = str;
    }

    public int fA() {
        return this.wQ;
    }

    public int fB() {
        return this.wR;
    }

    public boolean fC() {
        return this.wT;
    }

    public int fy() {
        return this.wO;
    }

    public String fz() {
        return this.wP;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String toString() {
        return "SlamModel{id='" + this.id + "', placeType=" + this.wO + ", position='" + this.wP + "', distance=" + this.wQ + ", pitchAngle=" + this.wR + ", rotation='" + this.wS + "', mImmediatelyPlaceModel=" + this.wT + '}';
    }
}
