package com.baidu.ar.face.detector;
/* loaded from: classes3.dex */
public class j extends com.baidu.ar.d.h {
    private int mCacheSize;
    private String pb;
    private String pc;
    private String pd;
    private String pe;
    private String pf;
    private String pg;
    private String ph;
    private String pi;
    private String pj;
    private String pk;
    private int pl;
    private int pm;
    private float pn;
    private float po;
    private float pp;

    public j() {
        super(com.baidu.ar.d.i.FACE);
        this.pn = 0.03f;
        this.po = 1.0f;
        this.pp = -1.0f;
        this.mCacheSize = 5;
    }

    public void I(int i) {
        this.pl = i;
    }

    public void J(int i) {
        this.pm = i;
    }

    public void ac(String str) {
        this.pb = str;
    }

    public void ad(String str) {
        this.pc = str;
    }

    public void ae(String str) {
        this.pd = str;
    }

    public void af(String str) {
        this.pe = str;
    }

    public void ag(String str) {
        this.pf = str;
    }

    public void ah(String str) {
        this.pg = str;
    }

    public void ai(String str) {
        this.ph = str;
    }

    public void aj(String str) {
        this.pi = str;
    }

    public void ak(String str) {
        this.pj = str;
    }

    public void al(String str) {
        this.pk = str;
    }

    public String en() {
        return this.pb;
    }

    public String eo() {
        return this.pc;
    }

    public String ep() {
        return this.pd;
    }

    public String eq() {
        return this.pe;
    }

    public String er() {
        return this.pf;
    }

    public String es() {
        return this.pg;
    }

    public String et() {
        return this.ph;
    }

    public String eu() {
        return this.pi;
    }

    public String ev() {
        return this.pj;
    }

    public String ew() {
        return this.pk;
    }

    public int ex() {
        return this.pl;
    }

    public int ey() {
        return this.pm;
    }

    public void setTrackingMouthThreshold(float f) {
        this.pp = f;
    }

    public void setTrackingSmoothAlpha(float f) {
        this.pn = f;
    }

    public void setTrackingSmoothThreshold(float f) {
        this.po = f;
    }
}
