package com.baidu.mario.b.b;

import com.baidu.ala.livePlayer.StreamConfig;
/* loaded from: classes2.dex */
public class d {
    private String ayi = "/sdcard/AR/video/arvideo.mp4";
    private int ayj = 0;
    private long ayk = 0;
    private boolean ayl = true;
    private int mVideoWidth = 720;
    private int mVideoHeight = 1280;
    private String aym = "video/avc";
    private int ayn = 8294400;
    private int ayo = 30;
    private int ayp = 1;
    private boolean ayq = false;
    private String ayr = "audio/mp4a-latm";
    private int ays = 1;
    private int ayt = 128000;
    private int ayu = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_16K;
    private int ayv = 1024;

    public String yM() {
        return this.ayi;
    }

    public void dq(String str) {
        if (str != null && !str.isEmpty()) {
            this.ayi = str;
        }
    }

    public int yN() {
        return this.ayj;
    }

    public long yO() {
        return this.ayk;
    }

    public void R(long j) {
        this.ayk = j;
    }

    public boolean yP() {
        return this.ayl;
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

    public String yQ() {
        return this.aym;
    }

    public int yR() {
        return this.ayn;
    }

    public int yS() {
        return this.ayo;
    }

    public int yT() {
        return this.ayp;
    }

    public boolean yU() {
        return this.ayq;
    }

    public void bh(boolean z) {
        this.ayq = z;
    }

    public String yV() {
        return this.ayr;
    }

    public int yW() {
        return this.ays;
    }

    public int yX() {
        return this.ayt;
    }

    public int yY() {
        return this.ayu;
    }

    public int yZ() {
        return this.ayv;
    }
}
