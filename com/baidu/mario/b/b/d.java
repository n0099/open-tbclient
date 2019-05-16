package com.baidu.mario.b.b;
/* loaded from: classes2.dex */
public class d {
    private String aeF = "/sdcard/AR/video/arvideo.mp4";
    private int aeG = 0;
    private long aeH = 0;
    private boolean aeI = true;
    private int mVideoWidth = 720;
    private int mVideoHeight = 1280;
    private String aeJ = "video/avc";
    private int aeK = 8294400;
    private int aeL = 30;
    private int aeM = 1;
    private boolean aeN = false;
    private String aeO = "audio/mp4a-latm";
    private int aeP = 1;
    private int aeQ = 128000;
    private int aeR = 16000;
    private int aeS = 1024;

    public String ts() {
        return this.aeF;
    }

    public void setOutputFile(String str) {
        if (str != null && !str.isEmpty()) {
            this.aeF = str;
        }
    }

    public int tt() {
        return this.aeG;
    }

    public long tu() {
        return this.aeH;
    }

    public void z(long j) {
        this.aeH = j;
    }

    public boolean tv() {
        return this.aeI;
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

    public String tw() {
        return this.aeJ;
    }

    public int tx() {
        return this.aeK;
    }

    public int ty() {
        return this.aeL;
    }

    public int tz() {
        return this.aeM;
    }

    public boolean tA() {
        return this.aeN;
    }

    public void aM(boolean z) {
        this.aeN = z;
    }

    public String tB() {
        return this.aeO;
    }

    public int tC() {
        return this.aeP;
    }

    public int tD() {
        return this.aeQ;
    }

    public int getAudioSampleRate() {
        return this.aeR;
    }

    public int tE() {
        return this.aeS;
    }
}
