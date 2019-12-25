package com.baidu.mario.a.b;
/* loaded from: classes9.dex */
public class d {
    private String aFW = "/sdcard/AR/video/arvideo.mp4";
    private int aFX = 0;
    private long aFY = 0;
    private boolean aFZ = true;
    private int mVideoWidth = 720;
    private int mVideoHeight = 1280;
    private String aGa = "video/avc";
    private int aGb = 8294400;
    private int aGc = 30;
    private int aGd = 1;
    private boolean aGe = false;
    private String aGf = "audio/mp4a-latm";
    private int aGg = 1;
    private int aGh = 128000;
    private int aGi = 16000;
    private int aGj = 1024;

    public String AA() {
        return this.aFW;
    }

    public void setOutputFile(String str) {
        if (str != null && !str.isEmpty()) {
            this.aFW = str;
        }
    }

    public int AB() {
        return this.aFX;
    }

    public long AC() {
        return this.aFY;
    }

    public void S(long j) {
        this.aFY = j;
    }

    public boolean AD() {
        return this.aFZ;
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

    public String AE() {
        return this.aGa;
    }

    public int AF() {
        return this.aGb;
    }

    public int AG() {
        return this.aGc;
    }

    public int AH() {
        return this.aGd;
    }

    public boolean AI() {
        return this.aGe;
    }

    public void bw(boolean z) {
        this.aGe = z;
    }

    public String AJ() {
        return this.aGf;
    }

    public int AK() {
        return this.aGg;
    }

    public void cO(int i) {
        this.aGg = i;
    }

    public int AL() {
        return this.aGh;
    }

    public int AM() {
        return this.aGi;
    }

    public void cP(int i) {
        this.aGi = i;
    }

    public int AN() {
        return this.aGj;
    }

    public void cQ(int i) {
        this.aGj = i;
    }
}
