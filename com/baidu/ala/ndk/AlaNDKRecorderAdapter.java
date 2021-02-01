package com.baidu.ala.ndk;
/* loaded from: classes6.dex */
public class AlaNDKRecorderAdapter {
    public static final int NATIVE_AUDIO_CAPTURE_FAIL_EXCEPTION = 3;
    public static final int NATIVE_AUDIO_ENCODE_FAIL_EXCEPTION = 4;
    public static final int NATIVE_COMMON_MODE = 1;
    public static final int NATIVE_RTC_MODE = 2;
    public static final int NATIVE_VIDEO_CAPTURE_FAIL_EXCEPTION = 1;
    public static final int NATIVE_VIDEO_ENCODE_FAIL_EXCEPTION = 2;
    private long mNativeObject = 0;

    private native int audioReSampleNative(long j, byte[] bArr, int i, byte[] bArr2, int i2);

    private native void enterBackground(long j);

    private native void enterForeground(long j);

    private native String getPushStreamIpNative(long j);

    private native float getStreamStateNative(long j, int[] iArr, int[] iArr2);

    private native int initAudioEncoderNative(long j, int i, int i2, int i3);

    private native int initAudioReSampleNative(long j, int i, int i2, int i3, int i4, int i5, int i6);

    private native int initNative(Object obj, int i, int i2);

    private native int initPKPlayer(long j, Object obj);

    private native int initRtcRoomInfoNative(long j, long j2, long j3, long j4, String str);

    private native int initVideoEncoderNative(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    private native void logMediaExceptionNative(long j, int i);

    private native void networkChangedNotifyNative(long j, int i);

    private native int restartNative(long j, String str);

    private native int sendEncodeVideoDataNative(long j, byte[] bArr, int i, String str, long j2, long j3, int i2);

    private native void sendNativeStatAppData(long j, String str, String str2, int i);

    private native int sendPCMDataNative(long j, byte[] bArr, int i, long j2, long j3);

    private native int sendPCMDataNative2(long j, byte[] bArr, int i, long j2, long j3);

    private native int sendYuvDataNative(long j, byte[] bArr, int i, int i2, int i3, long j2, long j3, String str, int i4, int[] iArr);

    private native void setDebugMonitor(long j, boolean z, int i);

    private native void setPreDetectedBestDnsNative(long j, String str, String str2);

    private native int setRtcConfig(long j, int i, int i2, int i3, int i4);

    private native int setX264Config(long j, int i, String str, String str2);

    private native int startNative(long j, String str, int i, String str2);

    private native int startX264Encode(long j, String str, String str2);

    private native int stopNative(long j);

    private native void syncStatConfig(long j, String str, String str2, int i);

    private native int updateVCodeParamNative(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public void setNativeObject(long j) {
        this.mNativeObject = j;
    }

    public long getNativeObject() {
        return this.mNativeObject;
    }

    public int initRecordNative(Object obj, int i, int i2) {
        return initNative(obj, i, i2);
    }

    public int initVideoEncoderNative(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return initVideoEncoderNative(this.mNativeObject, i, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public int initAudioEncoderNative(int i, int i2, int i3) {
        return initAudioEncoderNative(this.mNativeObject, i, i2, i3);
    }

    public int initRtcRoomInfoNative(long j, long j2, long j3, String str) {
        return initRtcRoomInfoNative(this.mNativeObject, j, j2, j3, str);
    }

    public void enterBackground() {
        enterBackground(this.mNativeObject);
    }

    public void enterForeground() {
        enterForeground(this.mNativeObject);
    }

    public void sendNativeStatAppData(String str, String str2, int i) {
        sendNativeStatAppData(this.mNativeObject, str, str2, i);
    }

    public void setDebugMonitor(boolean z, int i) {
        setDebugMonitor(this.mNativeObject, z, i);
    }

    public void setPreDetectedBestDns(String str, String str2) {
        setPreDetectedBestDnsNative(this.mNativeObject, str, str2);
    }

    public int startNative(String str, int i, String str2) {
        return startNative(this.mNativeObject, str, i, str2);
    }

    public int stopNative() {
        return stopNative(this.mNativeObject);
    }

    public int restartNative(String str) {
        return restartNative(this.mNativeObject, str);
    }

    public int sendPCMDataNative(byte[] bArr, int i, long j, long j2) {
        return sendPCMDataNative(this.mNativeObject, bArr, i, j, j2);
    }

    public int sendPCMDataNative2(byte[] bArr, int i, long j, long j2) {
        return sendPCMDataNative2(this.mNativeObject, bArr, i, j, j2);
    }

    public int sendEncodeVideoData(byte[] bArr, int i, String str, long j, long j2, int i2) {
        return sendEncodeVideoDataNative(this.mNativeObject, bArr, i, str, j, j2, i2);
    }

    public int sendYuvData(byte[] bArr, int i, int i2, int i3, long j, long j2, String str, int i4, int[] iArr) {
        return sendYuvDataNative(this.mNativeObject, bArr, i, i2, i3, j, j2, str, i4, iArr);
    }

    public String getPushStreamIpNative() {
        return getPushStreamIpNative(this.mNativeObject);
    }

    public void networkChangedNotifyNative(int i) {
        networkChangedNotifyNative(this.mNativeObject, i);
    }

    public float getStreamStateNative(int[] iArr, int[] iArr2) {
        return getStreamStateNative(this.mNativeObject, iArr, iArr2);
    }

    public int updateVCodeParamNative(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return updateVCodeParamNative(this.mNativeObject, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void syncStatConfig(String str, String str2, int i) {
        syncStatConfig(this.mNativeObject, str, str2, i);
    }

    public int initPKPlayer(Object obj) {
        return initPKPlayer(this.mNativeObject, obj);
    }

    public int initAudioReSample(int i, int i2, int i3, int i4, int i5, int i6) {
        return initAudioReSampleNative(this.mNativeObject, i, i2, i3, i4, i5, i6);
    }

    public int audioReSample(byte[] bArr, int i, byte[] bArr2, int i2) {
        return audioReSampleNative(this.mNativeObject, bArr, i, bArr2, i2);
    }

    public int setRtcConfig(int i, int i2, int i3, int i4) {
        return setRtcConfig(this.mNativeObject, i, i2, i3, i4);
    }

    public void logMediaException(int i) {
        logMediaExceptionNative(this.mNativeObject, i);
    }

    public int startX264EncodeToNative(String str, String str2) {
        return startX264Encode(this.mNativeObject, str, str2);
    }

    public int setX264ConfigToNative(int i, String str, String str2) {
        return setX264Config(this.mNativeObject, i, str, str2);
    }
}
