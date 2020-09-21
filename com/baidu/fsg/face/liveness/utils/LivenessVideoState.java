package com.baidu.fsg.face.liveness.utils;
/* loaded from: classes16.dex */
public class LivenessVideoState {
    public static final int STATE_RECOG_FIRST = 1;
    public static final int STATE_RECOG_INIT = 0;
    public static final int STATE_SHOWING_LRCTIP = 3;
    public static final int STATE_TO_SHOW_LRCTIP = 2;
    public static final int STATE_TO_START_VIDEO = 4;
    public static final int STATE_VIDEO = 5;
    public static final int STATE_VIDEO_DONE = 6;
    private long a;
    private long b;
    public boolean isLrcTipAnimCalling;
    public boolean isWarningTipAnimCalled;
    public long lrcTextStartTime;
    public int reqTimes;
    public int currentState = 0;
    public int currentCount = 0;
    private boolean c = false;
    public boolean isLrcTipViewHadGone = false;

    public boolean isFirstRecog() {
        return this.currentState == 1;
    }

    public void updateState(int i) {
        this.currentState = i;
    }

    public void setLrcTextStartTime() {
        this.lrcTextStartTime = System.currentTimeMillis();
    }

    public String getLrcStartTimeOffset() {
        return ((this.lrcTextStartTime - this.a) / 1000) + "";
    }

    public void setProcessStartTime() {
        this.a = System.currentTimeMillis();
        setLastFindFaceStartTime();
    }

    public boolean isFirstRecogTimeout() {
        return this.currentState < 5 && System.currentTimeMillis() - this.a > 20000;
    }

    public long getVideoTime() {
        return (System.currentTimeMillis() - this.a) / 1000;
    }

    public void setLastFindFaceStartTime() {
        this.b = System.currentTimeMillis();
    }

    public boolean isVideoStateLostFaceTimeout() {
        return this.currentState == 5 && System.currentTimeMillis() - this.b > 5000;
    }

    public boolean isGotoRecogFace(long[] jArr) {
        if (this.currentState < 5 && !this.c) {
            this.c = true;
            return true;
        } else if (this.currentState == 5) {
            if (jArr == null || jArr.length == 0) {
                return false;
            }
            if (jArr.length > this.currentCount && (System.currentTimeMillis() - this.lrcTextStartTime) / 1000 == jArr[this.currentCount]) {
                this.currentCount++;
                return true;
            } else if (jArr.length <= this.currentCount || (System.currentTimeMillis() - this.lrcTextStartTime) / 1000 <= jArr[this.currentCount]) {
                return false;
            } else {
                this.currentCount++;
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isWarnCancleTipAfterOnPause() {
        return this.currentState < 6;
    }

    public boolean isInitOk() {
        return this.currentState > 0;
    }
}
