package com.baidu.ar.face.detector;
/* loaded from: classes11.dex */
public class j extends com.baidu.ar.d.h {
    private int mCacheSize;
    private String oL;
    private String oM;
    private String oN;
    private String oO;
    private String oP;
    private String oQ;
    private String oR;
    private String oS;
    private String oT;
    private String oU;
    private int oV;
    private int oW;
    private float oX;
    private float oY;
    private float oZ;

    public j() {
        super(com.baidu.ar.d.i.FACE);
        this.oX = 0.03f;
        this.oY = 1.0f;
        this.oZ = -1.0f;
        this.mCacheSize = 5;
    }

    public void G(int i) {
        this.oV = i;
    }

    public void H(int i) {
        this.oW = i;
    }

    public void Z(String str) {
        this.oL = str;
    }

    public void aa(String str) {
        this.oM = str;
    }

    public void ab(String str) {
        this.oN = str;
    }

    public void ac(String str) {
        this.oO = str;
    }

    public void ad(String str) {
        this.oP = str;
    }

    public void ae(String str) {
        this.oQ = str;
    }

    public void af(String str) {
        this.oR = str;
    }

    public void ag(String str) {
        this.oS = str;
    }

    public void ah(String str) {
        this.oT = str;
    }

    public void ai(String str) {
        this.oU = str;
    }

    public String eo() {
        return this.oL;
    }

    public String ep() {
        return this.oM;
    }

    public String eq() {
        return this.oN;
    }

    public String er() {
        return this.oO;
    }

    public String es() {
        return this.oP;
    }

    public String et() {
        return this.oQ;
    }

    public String eu() {
        return this.oR;
    }

    public String ev() {
        return this.oS;
    }

    public String ew() {
        return this.oT;
    }

    public String ex() {
        return this.oU;
    }

    public int ey() {
        return this.oV;
    }

    public int ez() {
        return this.oW;
    }

    public void setTrackingMouthThreshold(float f) {
        this.oZ = f;
    }

    public void setTrackingSmoothAlpha(float f) {
        this.oX = f;
    }

    public void setTrackingSmoothThreshold(float f) {
        this.oY = f;
    }
}
