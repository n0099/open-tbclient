package com.baidu.mario.b.b;

import com.baidu.ala.livePlayer.StreamConfig;
/* loaded from: classes2.dex */
public class d {
    private String ayA = "/sdcard/AR/video/arvideo.mp4";
    private int ayB = 0;
    private long ayC = 0;
    private boolean ayD = true;
    private int mVideoWidth = 720;
    private int mVideoHeight = 1280;
    private String ayE = "video/avc";
    private int ayF = 8294400;
    private int ayG = 30;
    private int ayH = 1;
    private boolean ayI = false;
    private String ayJ = "audio/mp4a-latm";
    private int ayK = 1;
    private int ayL = 128000;
    private int ayM = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_16K;
    private int ayN = 1024;

    public String yL() {
        return this.ayA;
    }

    public void dq(String str) {
        if (str != null && !str.isEmpty()) {
            this.ayA = str;
        }
    }

    public int yM() {
        return this.ayB;
    }

    public long yN() {
        return this.ayC;
    }

    public void S(long j) {
        this.ayC = j;
    }

    public boolean yO() {
        return this.ayD;
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

    public String yP() {
        return this.ayE;
    }

    public int yQ() {
        return this.ayF;
    }

    public int yR() {
        return this.ayG;
    }

    public int yS() {
        return this.ayH;
    }

    public boolean yT() {
        return this.ayI;
    }

    public void bh(boolean z) {
        this.ayI = z;
    }

    public String yU() {
        return this.ayJ;
    }

    public int yV() {
        return this.ayK;
    }

    public int yW() {
        return this.ayL;
    }

    public int yX() {
        return this.ayM;
    }

    public int yY() {
        return this.ayN;
    }
}
