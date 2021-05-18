package com.baidu.fsg.face.liveness.utils;
/* loaded from: classes2.dex */
public class LivenessVideoState {
    public static final int STATE_RECOG_FIRST = 1;
    public static final int STATE_RECOG_INIT = 0;
    public static final int STATE_SHOWING_LRCTIP = 3;
    public static final int STATE_TO_SHOW_LRCTIP = 2;
    public static final int STATE_TO_START_VIDEO = 4;
    public static final int STATE_VIDEO = 5;
    public static final int STATE_VIDEO_DONE = 6;

    /* renamed from: a  reason: collision with root package name */
    public long f6040a;

    /* renamed from: b  reason: collision with root package name */
    public long f6041b;
    public boolean isLrcTipAnimCalling;
    public boolean isWarningTipAnimCalled;
    public long lrcTextStartTime;
    public int reqTimes;
    public int currentState = 0;
    public int currentCount = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6042c = false;
    public boolean isLrcTipViewHadGone = false;

    public String getLrcStartTimeOffset() {
        return ((this.lrcTextStartTime - this.f6040a) / 1000) + "";
    }

    public long getVideoTime() {
        return (System.currentTimeMillis() - this.f6040a) / 1000;
    }

    public boolean isFirstRecog() {
        return this.currentState == 1;
    }

    public boolean isFirstRecogTimeout() {
        return this.currentState < 5 && System.currentTimeMillis() - this.f6040a > 20000;
    }

    public boolean isGotoRecogFace(long[] jArr) {
        if (this.currentState < 5 && !this.f6042c) {
            this.f6042c = true;
            return true;
        }
        if (this.currentState == 5 && jArr != null && jArr.length != 0) {
            if (jArr.length > this.currentCount) {
                int i2 = this.currentCount;
                if ((System.currentTimeMillis() - this.lrcTextStartTime) / 1000 == jArr[i2]) {
                    this.currentCount = i2 + 1;
                    return true;
                }
            }
            if (jArr.length > this.currentCount) {
                int i3 = this.currentCount;
                if ((System.currentTimeMillis() - this.lrcTextStartTime) / 1000 > jArr[i3]) {
                    this.currentCount = i3 + 1;
                }
            }
        }
        return false;
    }

    public boolean isInitOk() {
        return this.currentState > 0;
    }

    public boolean isVideoStateLostFaceTimeout() {
        return this.currentState == 5 && System.currentTimeMillis() - this.f6041b > 5000;
    }

    public boolean isWarnCancleTipAfterOnPause() {
        return this.currentState < 6;
    }

    public void setLastFindFaceStartTime() {
        this.f6041b = System.currentTimeMillis();
    }

    public void setLrcTextStartTime() {
        this.lrcTextStartTime = System.currentTimeMillis();
    }

    public void setProcessStartTime() {
        this.f6040a = System.currentTimeMillis();
        setLastFindFaceStartTime();
    }

    public void updateState(int i2) {
        this.currentState = i2;
    }
}
