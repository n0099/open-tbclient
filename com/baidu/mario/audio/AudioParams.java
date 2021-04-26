package com.baidu.mario.audio;

import com.baidu.searchbox.v8engine.NotProguard;
@NotProguard
/* loaded from: classes2.dex */
public class AudioParams {
    public static final int DEFAULT_AUDIO_BUFFER_SIZE = 32768;
    public static final int DEFAULT_AUDIO_FORMAT = 2;
    public static final int DEFAULT_AUDIO_SOURCE = 1;
    public static final int DEFAULT_BUFFER_FRAME_COUNT = 32;
    public static final int DEFAULT_CHANNEL_CONFIG = 16;
    public static final int DEFAULT_FRAME_SIZE = 1024;
    public static final int DEFAULT_SAMPLE_RATE = 16000;
    public static final int SAMPLES_PER_FRAME = 1024;
    public int mAudioSource = 1;
    public int mSampleRate = 16000;
    public int mChannelConfig = 16;
    public int mAudioFormat = 2;
    public int mFrameSize = 1024;
    public int mFrameBufferCount = 32;
    public int mAudioBufferSize = 32768;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof AudioParams)) {
            AudioParams audioParams = (AudioParams) obj;
            return this.mAudioSource == audioParams.mAudioSource && this.mSampleRate == audioParams.getSampleRate() && this.mChannelConfig == audioParams.getChannelConfig() && this.mAudioFormat == audioParams.getAudioFormat() && this.mFrameSize == audioParams.getFrameSize();
        }
        return false;
    }

    public int getAudioBufferSize() {
        return this.mAudioBufferSize;
    }

    public int getAudioFormat() {
        return this.mAudioFormat;
    }

    public int getAudioSource() {
        return this.mAudioSource;
    }

    public int getChannelConfig() {
        return this.mChannelConfig;
    }

    public int getFrameBufferCount() {
        return this.mFrameBufferCount;
    }

    public int getFrameSize() {
        return this.mFrameSize;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public int hashCode() {
        return ((((((((this.mAudioSource + 31) * 31) + this.mSampleRate) * 31) + this.mChannelConfig) * 31) + this.mAudioFormat) * 31) + this.mFrameSize;
    }

    public void setAudioBufferSize(int i2) {
        this.mAudioBufferSize = i2;
    }

    public void setAudioFormat(int i2) {
        this.mAudioFormat = i2;
    }

    public void setAudioSource(int i2) {
        this.mAudioSource = i2;
    }

    public void setChannelConfig(int i2) {
        this.mChannelConfig = i2;
    }

    public void setFrameBufferCount(int i2) {
        this.mFrameBufferCount = i2;
    }

    public void setFrameSize(int i2) {
        this.mFrameSize = i2;
    }

    public void setSampleRate(int i2) {
        this.mSampleRate = i2;
    }
}
