package com.baidu.mario.a.b;
/* loaded from: classes11.dex */
public class d {
    private String aKT = "/sdcard/AR/video/arvideo.mp4";
    private int aKU = 0;
    private long aKV = 0;
    private boolean aKW = true;
    private int mVideoWidth = 720;
    private int mVideoHeight = 1280;
    private String aKX = "video/avc";
    private int aKY = 8294400;
    private int aKZ = 30;
    private int aLa = 1;
    private boolean aLb = false;
    private String aLc = "audio/mp4a-latm";
    private int aLd = 1;
    private int aLe = 128000;
    private int aLf = 16000;
    private int aLg = 1024;

    public String Dm() {
        return this.aKT;
    }

    public void setOutputFile(String str) {
        if (str != null && !str.isEmpty()) {
            this.aKT = str;
        }
    }

    public int Dn() {
        return this.aKU;
    }

    public long Do() {
        return this.aKV;
    }

    public void Z(long j) {
        this.aKV = j;
    }

    public boolean Dp() {
        return this.aKW;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public void setVideoWidth(int i) {
        this.mVideoWidth = i;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public void setVideoHeight(int i) {
        this.mVideoHeight = i;
    }

    public String Dq() {
        return this.aKX;
    }

    public int Dr() {
        return this.aKY;
    }

    public int Ds() {
        return this.aKZ;
    }

    public int Dt() {
        return this.aLa;
    }

    public boolean Du() {
        return this.aLb;
    }

    public void bJ(boolean z) {
        this.aLb = z;
    }

    public String Dv() {
        return this.aLc;
    }

    public int Dw() {
        return this.aLd;
    }

    public void df(int i) {
        this.aLd = i;
    }

    public int Dx() {
        return this.aLe;
    }

    public int Dy() {
        return this.aLf;
    }

    public void dg(int i) {
        this.aLf = i;
    }

    public int Dz() {
        return this.aLg;
    }

    public void dh(int i) {
        this.aLg = i;
    }
}
