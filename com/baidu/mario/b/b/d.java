package com.baidu.mario.b.b;
/* loaded from: classes2.dex */
public class d {
    private String afc = "/sdcard/AR/video/arvideo.mp4";
    private int afd = 0;
    private long afe = 0;
    private boolean aff = true;
    private int mVideoWidth = 720;
    private int mVideoHeight = 1280;
    private String afg = "video/avc";
    private int afh = 8294400;
    private int afi = 30;
    private int afj = 1;
    private boolean afk = false;
    private String afl = "audio/mp4a-latm";
    private int afm = 1;
    private int afn = 128000;
    private int afo = 16000;
    private int afp = 1024;

    public String tR() {
        return this.afc;
    }

    public void cF(String str) {
        if (str != null && !str.isEmpty()) {
            this.afc = str;
        }
    }

    public int tS() {
        return this.afd;
    }

    public long tT() {
        return this.afe;
    }

    public void z(long j) {
        this.afe = j;
    }

    public boolean tU() {
        return this.aff;
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

    public String tV() {
        return this.afg;
    }

    public int tW() {
        return this.afh;
    }

    public int tX() {
        return this.afi;
    }

    public int tY() {
        return this.afj;
    }

    public boolean tZ() {
        return this.afk;
    }

    public void aP(boolean z) {
        this.afk = z;
    }

    public String ua() {
        return this.afl;
    }

    public int ub() {
        return this.afm;
    }

    public int uc() {
        return this.afn;
    }

    public int ud() {
        return this.afo;
    }

    public int ue() {
        return this.afp;
    }
}
