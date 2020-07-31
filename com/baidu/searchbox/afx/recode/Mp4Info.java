package com.baidu.searchbox.afx.recode;

import com.baidu.mobstat.Config;
/* loaded from: classes6.dex */
public final class Mp4Info {
    private final int mBitrate;
    private final long mDurationUs;
    private final int mHeight;
    private final int mRotation;
    private final int mWidth;

    public Mp4Info(int i, int i2, int i3, int i4, long j) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mRotation = i3;
        this.mBitrate = i4;
        this.mDurationUs = j;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public long getDurationUs() {
        return this.mDurationUs;
    }

    public String toString() {
        return "[" + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + "], rotation: " + this.mRotation + ", bitrate: " + this.mBitrate + ", duration(us): " + this.mDurationUs;
    }
}
