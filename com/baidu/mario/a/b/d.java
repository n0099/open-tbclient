package com.baidu.mario.a.b;
/* loaded from: classes11.dex */
public class d {
    private String aKV = "/sdcard/AR/video/arvideo.mp4";
    private int aKW = 0;
    private long aKX = 0;
    private boolean aKY = true;
    private int mVideoWidth = 720;
    private int mVideoHeight = 1280;
    private String aKZ = "video/avc";
    private int aLa = 8294400;
    private int aLb = 30;
    private int aLc = 1;
    private boolean aLd = false;
    private String aLe = "audio/mp4a-latm";
    private int aLf = 1;
    private int aLg = 128000;
    private int aLh = 16000;
    private int aLi = 1024;

    public String Do() {
        return this.aKV;
    }

    public void setOutputFile(String str) {
        if (str != null && !str.isEmpty()) {
            this.aKV = str;
        }
    }

    public int Dp() {
        return this.aKW;
    }

    public long Dq() {
        return this.aKX;
    }

    public void Z(long j) {
        this.aKX = j;
    }

    public boolean Dr() {
        return this.aKY;
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
        return this.aKZ;
    }

    public int Dt() {
        return this.aLa;
    }

    public int Du() {
        return this.aLb;
    }

    public int Dv() {
        return this.aLc;
    }

    public boolean Dw() {
        return this.aLd;
    }

    public void bJ(boolean z) {
        this.aLd = z;
    }

    public String Dx() {
        return this.aLe;
    }

    public int Dy() {
        return this.aLf;
    }

    public void df(int i) {
        this.aLf = i;
    }

    public int Dz() {
        return this.aLg;
    }

    public int DA() {
        return this.aLh;
    }

    public void dg(int i) {
        this.aLh = i;
    }

    public int DB() {
        return this.aLi;
    }

    public void dh(int i) {
        this.aLi = i;
    }
}
