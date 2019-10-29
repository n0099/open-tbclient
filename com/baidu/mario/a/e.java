package com.baidu.mario.a;

import com.baidu.ala.livePlayer.StreamConfig;
/* loaded from: classes2.dex */
public class e {
    private int mAudioSource = 1;
    private int mSampleRate = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_16K;
    private int mChannelConfig = 16;
    private int mAudioFormat = 2;
    private int mFrameSize = 1024;
    private int mFrameBufferCount = 32;
    private int mAudioBufferSize = 32768;

    public int getAudioSource() {
        return this.mAudioSource;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public int getChannelConfig() {
        return this.mChannelConfig;
    }

    public int getAudioFormat() {
        return this.mAudioFormat;
    }

    public int getFrameSize() {
        return this.mFrameSize;
    }

    public int getFrameBufferCount() {
        return this.mFrameBufferCount;
    }

    public int getAudioBufferSize() {
        return this.mAudioBufferSize;
    }

    public void setAudioBufferSize(int i) {
        this.mAudioBufferSize = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof e)) {
            e eVar = (e) obj;
            return this.mAudioSource == eVar.mAudioSource && this.mSampleRate == eVar.getSampleRate() && this.mChannelConfig == eVar.getChannelConfig() && this.mAudioFormat == eVar.getAudioFormat() && this.mFrameSize == eVar.getFrameSize();
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.mAudioSource + 31) * 31) + this.mSampleRate) * 31) + this.mChannelConfig) * 31) + this.mAudioFormat) * 31) + this.mFrameSize;
    }
}
