package com.baidu.mario.a.b;
/* loaded from: classes11.dex */
public class d {
    private String aLj = "/sdcard/AR/video/arvideo.mp4";
    private int aLk = 0;
    private long aLl = 0;
    private boolean aLm = true;
    private int mVideoWidth = 720;
    private int mVideoHeight = 1280;
    private String aLn = "video/avc";
    private int aLo = 8294400;
    private int aLp = 30;
    private int aLq = 1;
    private boolean aLr = false;
    private String aLs = "audio/mp4a-latm";
    private int aLt = 1;
    private int aLu = 128000;
    private int aLv = 16000;
    private int aLw = 1024;

    public String Dv() {
        return this.aLj;
    }

    public void setOutputFile(String str) {
        if (str != null && !str.isEmpty()) {
            this.aLj = str;
        }
    }

    public int Dw() {
        return this.aLk;
    }

    public long Dx() {
        return this.aLl;
    }

    public void Z(long j) {
        this.aLl = j;
    }

    public boolean Dy() {
        return this.aLm;
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

    public String Dz() {
        return this.aLn;
    }

    public int DA() {
        return this.aLo;
    }

    public int DB() {
        return this.aLp;
    }

    public int DC() {
        return this.aLq;
    }

    public boolean DD() {
        return this.aLr;
    }

    public void bK(boolean z) {
        this.aLr = z;
    }

    public String DE() {
        return this.aLs;
    }

    public int DF() {
        return this.aLt;
    }

    public void df(int i) {
        this.aLt = i;
    }

    public int DG() {
        return this.aLu;
    }

    public int DH() {
        return this.aLv;
    }

    public void dg(int i) {
        this.aLv = i;
    }

    public int DI() {
        return this.aLw;
    }

    public void dh(int i) {
        this.aLw = i;
    }
}
