package com.baidu.cyberplayer.sdk.rtc;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes3.dex */
public class CyberRTCAudioSamples {
    public final int mAudioFormat;
    public final int mChannelCount;
    public final byte[] mData;
    public final int mSampleRate;

    @Keep
    /* loaded from: classes3.dex */
    public interface CyberRTCSamplesReadyCallback {
        void onRtcAudioRecordSamplesReady(CyberRTCAudioSamples cyberRTCAudioSamples);
    }

    public CyberRTCAudioSamples(int i, int i2, int i3, byte[] bArr) {
        this.mAudioFormat = i;
        this.mChannelCount = i2;
        this.mSampleRate = i3;
        this.mData = bArr;
    }

    public int getAudioFormat() {
        return this.mAudioFormat;
    }

    public int getChannelCount() {
        return this.mChannelCount;
    }

    public byte[] getData() {
        return this.mData;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }
}
