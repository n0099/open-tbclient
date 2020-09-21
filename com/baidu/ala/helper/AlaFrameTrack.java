package com.baidu.ala.helper;
/* loaded from: classes12.dex */
public class AlaFrameTrack {
    private static final int ONE_SECONED_MS = 1000;
    private int mVideoFrameDur;
    private int mFpsLimit = 0;
    private int mFpsCount = 0;
    private long mFpsStart = 0;

    public AlaFrameTrack(int i) {
        this.mVideoFrameDur = 0;
        if (i > 0) {
            this.mVideoFrameDur = 1000 / i;
        }
    }

    public boolean trackFrame() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mFpsStart == 0) {
            this.mFpsStart = currentTimeMillis;
        }
        long j = currentTimeMillis % 1000;
        if (currentTimeMillis / 1000 != this.mFpsStart / 1000) {
            this.mFpsStart = currentTimeMillis;
            this.mFpsLimit = 0;
            this.mFpsCount = 0;
        }
        this.mFpsCount++;
        if (this.mFpsLimit * this.mVideoFrameDur < j) {
            this.mFpsLimit++;
            return true;
        }
        return false;
    }

    public int getAllFps() {
        return this.mFpsCount;
    }

    public int getCurrentFps() {
        return this.mFpsLimit;
    }

    public void setLimitFps(int i) {
        if (i > 0) {
            this.mVideoFrameDur = 1000 / i;
        }
    }
}
