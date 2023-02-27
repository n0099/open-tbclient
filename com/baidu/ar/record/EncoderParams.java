package com.baidu.ar.record;
/* loaded from: classes.dex */
public class EncoderParams {
    public static final int AAC_SAMPLES_PER_FRAME = 1024;
    public static final int AUDIO_BIT_RATE = 128000;
    public static final int AUDIO_CHANNEL = 1;
    public static final int AUDIO_FRAME_SIZE = 10240;
    public static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    public static final int AUDIO_SAMPLE_RATE = 44100;
    public static final String OUTPUT_FILE = "/sdcard/AR/arvideo/video/arvideo.mp4";
    public static final int OUTPUT_FORMAT = 0;
    public static final long OUTPUT_TOTAL_MS = 0;
    public static final int VIDEO_BIT_RATE = 3145728;
    public static final int VIDEO_FRAME_RATE = 30;
    public static final int VIDEO_HEIGHT = 1280;
    public static final int VIDEO_I_FRAME_INTERVAL = 1;
    public static final String VIDEO_MIME_TYPE = "video/avc";
    public static final int VIDEO_WIDTH = 720;
    public String mOutputFile = OUTPUT_FILE;
    public int mOutputFormat = 0;
    public long mOutputTotalMs = 0;
    public boolean mVideoIncluded = true;
    public int mVideoWidth = 720;
    public int mVideoHeight = 1280;
    public String mVideoCodec = "video/avc";
    public int mVideoBitrate = VIDEO_BIT_RATE;
    public int mVideoFrameRate = 30;
    public int mVideoIFrameInterval = 1;
    public boolean mAudioIncluded = true;
    public String mAudioCodec = "audio/mp4a-latm";
    public int mAudioChannel = 1;
    public int mAudioBitrate = AUDIO_BIT_RATE;
    public int mAudioSampleRate = 44100;
    public int mAudioFrameSize = 10240;

    public int getAudioBitrate() {
        return this.mAudioBitrate;
    }

    public int getAudioChannel() {
        return this.mAudioChannel;
    }

    public String getAudioCodec() {
        return this.mAudioCodec;
    }

    public int getAudioFrameSize() {
        return this.mAudioFrameSize;
    }

    public int getAudioSampleRate() {
        return this.mAudioSampleRate;
    }

    public String getOutputFile() {
        return this.mOutputFile;
    }

    public int getOutputFormat() {
        return this.mOutputFormat;
    }

    public long getOutputTotalMs() {
        return this.mOutputTotalMs;
    }

    public int getVideoBitrate() {
        return this.mVideoBitrate;
    }

    public String getVideoCodec() {
        return this.mVideoCodec;
    }

    public int getVideoFrameRate() {
        return this.mVideoFrameRate;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public int getVideoIFrameInterval() {
        return this.mVideoIFrameInterval;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public boolean isAudioIncluded() {
        return this.mAudioIncluded;
    }

    public boolean isVideoIncluded() {
        return this.mVideoIncluded;
    }

    public void setAudioBitrate(int i) {
        this.mAudioBitrate = i;
    }

    public void setAudioChannel(int i) {
        this.mAudioChannel = i;
    }

    public void setAudioCodec(String str) {
        this.mAudioCodec = str;
    }

    public void setAudioFrameSize(int i) {
        this.mAudioFrameSize = i;
    }

    public void setAudioIncluded(boolean z) {
        this.mAudioIncluded = z;
    }

    public void setAudioSampleRate(int i) {
        this.mAudioSampleRate = i;
    }

    public void setOutputFile(String str) {
        this.mOutputFile = str;
    }

    public void setOutputFormat(int i) {
        this.mOutputFormat = i;
    }

    public void setOutputTotalMs(long j) {
        this.mOutputTotalMs = j;
    }

    public void setVideoBitrate(int i) {
        this.mVideoBitrate = i;
    }

    public void setVideoCodec(String str) {
        this.mVideoCodec = str;
    }

    public void setVideoFrameRate(int i) {
        this.mVideoFrameRate = i;
    }

    public void setVideoHeight(int i) {
        this.mVideoHeight = i;
    }

    public void setVideoIFrameInterval(int i) {
        this.mVideoIFrameInterval = i;
    }

    public void setVideoIncluded(boolean z) {
        this.mVideoIncluded = z;
    }

    public void setVideoWidth(int i) {
        this.mVideoWidth = i;
    }
}
