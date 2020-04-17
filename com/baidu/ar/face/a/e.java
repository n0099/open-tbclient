package com.baidu.ar.face.a;

import com.baidu.ar.c.i;
/* loaded from: classes3.dex */
public class e extends com.baidu.ar.c.h {
    private int cD;
    private int cE;
    private int mCacheSize;
    private String nH;
    private String nI;
    private String nJ;
    private String nK;
    private String nL;
    private String nM;
    private String nN;
    private String nO;
    private String nP;
    private float nQ;
    private float nR;
    private float nS;

    public e() {
        super(i.FACE);
        this.nQ = 0.03f;
        this.nR = 1.0f;
        this.nS = -1.0f;
        this.mCacheSize = 5;
    }

    public void A(int i) {
        this.cE = i;
    }

    public void V(String str) {
        this.nH = str;
    }

    public void W(String str) {
        this.nI = str;
    }

    public void X(String str) {
        this.nJ = str;
    }

    public void Y(String str) {
        this.nK = str;
    }

    public void Z(String str) {
        this.nL = str;
    }

    public void aa(String str) {
        this.nM = str;
    }

    public void ab(String str) {
        this.nN = str;
    }

    public void ac(String str) {
        this.nO = str;
    }

    public void ad(String str) {
        this.nP = str;
    }

    public int aj() {
        return this.cD;
    }

    public int ak() {
        return this.cE;
    }

    public String cR() {
        return this.nH;
    }

    public String cS() {
        return this.nI;
    }

    public String cT() {
        return this.nJ;
    }

    public String cU() {
        return this.nK;
    }

    public String cV() {
        return this.nL;
    }

    public String cW() {
        return this.nM;
    }

    public String cX() {
        return this.nN;
    }

    public String cY() {
        return this.nO;
    }

    public String cZ() {
        return this.nP;
    }

    public float da() {
        return this.nQ;
    }

    public float db() {
        return this.nR;
    }

    public float dc() {
        return this.nS;
    }

    public void setTrackingMouthThreshold(float f) {
        this.nS = f;
    }

    public void setTrackingSmoothAlpha(float f) {
        this.nQ = f;
    }

    public void setTrackingSmoothThreshold(float f) {
        this.nR = f;
    }

    public void z(int i) {
        this.cD = i;
    }
}
