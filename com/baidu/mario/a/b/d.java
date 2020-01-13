package com.baidu.mario.a.b;
/* loaded from: classes10.dex */
public class d {
    private String aGO = "/sdcard/AR/video/arvideo.mp4";
    private int aGP = 0;
    private long aGQ = 0;
    private boolean aGR = true;
    private int mVideoWidth = 720;
    private int mVideoHeight = 1280;
    private String aGS = "video/avc";
    private int aGT = 8294400;
    private int aGU = 30;
    private int aGV = 1;
    private boolean aGW = false;
    private String aGX = "audio/mp4a-latm";
    private int aGY = 1;
    private int aGZ = 128000;
    private int aHa = 16000;
    private int aHb = 1024;

    public String AW() {
        return this.aGO;
    }

    public void setOutputFile(String str) {
        if (str != null && !str.isEmpty()) {
            this.aGO = str;
        }
    }

    public int AX() {
        return this.aGP;
    }

    public long AY() {
        return this.aGQ;
    }

    public void V(long j) {
        this.aGQ = j;
    }

    public boolean AZ() {
        return this.aGR;
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

    public String Ba() {
        return this.aGS;
    }

    public int Bb() {
        return this.aGT;
    }

    public int Bc() {
        return this.aGU;
    }

    public int Bd() {
        return this.aGV;
    }

    public boolean Be() {
        return this.aGW;
    }

    public void bB(boolean z) {
        this.aGW = z;
    }

    public String Bf() {
        return this.aGX;
    }

    public int Bg() {
        return this.aGY;
    }

    public void cP(int i) {
        this.aGY = i;
    }

    public int Bh() {
        return this.aGZ;
    }

    public int Bi() {
        return this.aHa;
    }

    public void cQ(int i) {
        this.aHa = i;
    }

    public int Bj() {
        return this.aHb;
    }

    public void cR(int i) {
        this.aHb = i;
    }
}
