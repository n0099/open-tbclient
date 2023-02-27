package com.baidu.searchbox.afx.recode;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes2.dex */
public final class Mp4Info {
    public final int mBitrate;
    public final long mDurationUs;
    public final int mHeight;
    public final int mRotation;
    public final int mWidth;

    public Mp4Info(int i, int i2, int i3, int i4, long j) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mRotation = i3;
        this.mBitrate = i4;
        this.mDurationUs = j;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public long getDurationUs() {
        return this.mDurationUs;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public String toString() {
        return PreferencesUtil.LEFT_MOUNT + this.mWidth + "x" + this.mHeight + "], rotation: " + this.mRotation + ", bitrate: " + this.mBitrate + ", duration(us): " + this.mDurationUs;
    }
}
