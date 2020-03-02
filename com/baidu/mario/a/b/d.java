package com.baidu.mario.a.b;
/* loaded from: classes11.dex */
public class d {
    private String aKU = "/sdcard/AR/video/arvideo.mp4";
    private int aKV = 0;
    private long aKW = 0;
    private boolean aKX = true;
    private int mVideoWidth = 720;
    private int mVideoHeight = 1280;
    private String aKY = "video/avc";
    private int aKZ = 8294400;
    private int aLa = 30;
    private int aLb = 1;
    private boolean aLc = false;
    private String aLd = "audio/mp4a-latm";
    private int aLe = 1;
    private int aLf = 128000;
    private int aLg = 16000;
    private int aLh = 1024;

    public String Do() {
        return this.aKU;
    }

    public void setOutputFile(String str) {
        if (str != null && !str.isEmpty()) {
            this.aKU = str;
        }
    }

    public int Dp() {
        return this.aKV;
    }

    public long Dq() {
        return this.aKW;
    }

    public void Z(long j) {
        this.aKW = j;
    }

    public boolean Dr() {
        return this.aKX;
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

    public String Ds() {
        return this.aKY;
    }

    public int Dt() {
        return this.aKZ;
    }

    public int Du() {
        return this.aLa;
    }

    public int Dv() {
        return this.aLb;
    }

    public boolean Dw() {
        return this.aLc;
    }

    public void bJ(boolean z) {
        this.aLc = z;
    }

    public String Dx() {
        return this.aLd;
    }

    public int Dy() {
        return this.aLe;
    }

    public void df(int i) {
        this.aLe = i;
    }

    public int Dz() {
        return this.aLf;
    }

    public int DA() {
        return this.aLg;
    }

    public void dg(int i) {
        this.aLg = i;
    }

    public int DB() {
        return this.aLh;
    }

    public void dh(int i) {
        this.aLh = i;
    }
}
