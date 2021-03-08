package com.baidu.mario.a.b;
/* loaded from: classes14.dex */
public class d {
    private String mOutputFile = "/sdcard/AR/video/arvideo.mp4";
    private int mOutputFormat = 0;
    private long mOutputTotalMs = 0;
    private boolean mVideoIncluded = true;
    private int mVideoWidth = 720;
    private int mVideoHeight = 1280;
    private String mVideoCodec = "video/avc";
    private int mVideoBitrate = 8294400;
    private int mVideoFrameRate = 30;
    private int mVideoIFrameInterval = 1;
    private boolean mAudioIncluded = false;
    private String mAudioCodec = "audio/mp4a-latm";
    private int mAudioChannel = 1;
    private int mAudioBitrate = 128000;
    private int mAudioSampleRate = 16000;
    private int mAudioFrameSize = 1024;

    public String getOutputFile() {
        return this.mOutputFile;
    }

    public void setOutputFile(String str) {
        if (str != null && !str.isEmpty()) {
            this.mOutputFile = str;
        }
    }

    public int getOutputFormat() {
        return this.mOutputFormat;
    }

    public long getOutputTotalMs() {
        return this.mOutputTotalMs;
    }

    public void setOutputTotalMs(long j) {
        this.mOutputTotalMs = j;
    }

    public boolean isVideoIncluded() {
        return this.mVideoIncluded;
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

    public String getVideoCodec() {
        return this.mVideoCodec;
    }

    public int getVideoBitrate() {
        return this.mVideoBitrate;
    }

    public int getVideoFrameRate() {
        return this.mVideoFrameRate;
    }

    public int getVideoIFrameInterval() {
        return this.mVideoIFrameInterval;
    }

    public boolean isAudioIncluded() {
        return this.mAudioIncluded;
    }

    public void setAudioIncluded(boolean z) {
        this.mAudioIncluded = z;
    }

    public String getAudioCodec() {
        return this.mAudioCodec;
    }

    public int getAudioChannel() {
        return this.mAudioChannel;
    }

    public void setAudioChannel(int i) {
        this.mAudioChannel = i;
    }

    public int getAudioBitrate() {
        return this.mAudioBitrate;
    }

    public int getAudioSampleRate() {
        return this.mAudioSampleRate;
    }

    public void setAudioSampleRate(int i) {
        this.mAudioSampleRate = i;
    }

    public int getAudioFrameSize() {
        return this.mAudioFrameSize;
    }

    public void setAudioFrameSize(int i) {
        this.mAudioFrameSize = i;
    }
}
