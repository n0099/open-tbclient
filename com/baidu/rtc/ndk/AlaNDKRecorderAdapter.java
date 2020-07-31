package com.baidu.rtc.ndk;

import com.baidu.rtc.utils.AlaLiveDebugInfo;
/* loaded from: classes7.dex */
public class AlaNDKRecorderAdapter {
    public static final int NATIVE_COMMON_MODE = 1;
    public static final int NATIVE_RTC_MODE = 2;
    public static final int NATIVE_RTC_ROOM_TYPE_AUDIO = 1;
    public static final int NATIVE_RTC_ROOM_TYPE_AUDIO_VIDEO_PK = 2;
    private OnNDKCallback mCallback = null;
    private long mNativeObject = 0;

    /* loaded from: classes7.dex */
    public interface OnNDKCallback {
        void onRemoteUserOnLine(int i, long j, int i2);

        void rtmpDebugResponsedCallback(AlaLiveDebugInfo alaLiveDebugInfo);

        void rtmpResponsedCallback(int i, int i2, int i3);
    }

    private native void enterBackground(long j);

    private native void enterForeground(long j);

    private native String getPushStreamIpNative(long j);

    private native float getStreamStateNative(long j, Integer num, Integer num2);

    private native int initAudioEncoderNative(long j, int i, int i2, int i3);

    private native int initAudioReSample(long j, int i, int i2, int i3);

    private native int initNative(Object obj, int i, int i2, int i3, int i4);

    private native int initPKPlayer(long j, Object obj);

    private native int initRtcRoomInfoNative(long j, long j2, long j3, long j4, String str, int i);

    private native int initRtcRoomTypeNative(long j, int i);

    private native int initVideoEncoderNative(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    private native int nV21ToRGBA(long j, byte[] bArr, int i, int i2, int i3, byte[] bArr2);

    private native void networkChangedNotifyNative(long j, int i);

    private native int restartNative(long j, String str);

    private native int sendAACDataNative(long j, byte[] bArr, int i);

    private native int sendH264DataNative(long j, byte[] bArr, int i, String str, long j2);

    private native void sendNativeStatAppData(long j, String str, String str2, int i);

    private native int sendPCMDataNative(long j, byte[] bArr, int i);

    private native int sendPCMDataNative2(long j, byte[] bArr, int i);

    private native void setDebugMonitor(long j, boolean z, int i);

    private native int setRtcConfig(long j, int i, int i2, int i3, int i4);

    private native int startNative(long j, String str, int i, String str2);

    private native int stopNative(long j);

    private native void syncStatConfig(long j, String str, String str2, int i);

    private native int updateVCodeParamNative(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    protected native int sendYuvDataNative(long j, byte[] bArr, int i, int i2, int i3, boolean z, byte[] bArr2, Integer num, String str);

    public void setNativeObject(long j) {
        this.mNativeObject = j;
    }

    public long getNativeObject() {
        return this.mNativeObject;
    }

    public void setNDKCallback(OnNDKCallback onNDKCallback) {
        this.mCallback = onNDKCallback;
    }

    public int initRecordNative(int i, int i2, int i3, int i4) {
        return initNative(this, i, i2, i3, i4);
    }

    public int initVideoEncoderNative(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (0 != this.mNativeObject) {
            return initVideoEncoderNative(this.mNativeObject, i, i2, i3, i4, i5, i6, i7, i8);
        }
        return -1;
    }

    public int initAudioEncoderNative(int i, int i2, int i3) {
        if (0 != this.mNativeObject) {
            return initAudioEncoderNative(this.mNativeObject, i, i2, i3);
        }
        return -1;
    }

    public int initRtcRoomType(int i) {
        if (0 != this.mNativeObject) {
            return initRtcRoomTypeNative(this.mNativeObject, i);
        }
        return -1;
    }

    public int initRtcRoomInfoNative(long j, long j2, long j3, String str, int i) {
        if (0 != this.mNativeObject) {
            return initRtcRoomInfoNative(this.mNativeObject, j, j2, j3, str, i);
        }
        return -1;
    }

    public void enterBackground() {
        if (0 != this.mNativeObject) {
            enterBackground(this.mNativeObject);
        }
    }

    public void enterForeground() {
        if (0 != this.mNativeObject) {
            enterForeground(this.mNativeObject);
        }
    }

    public void sendNativeStatAppData(String str, String str2, int i) {
        if (0 != this.mNativeObject) {
            sendNativeStatAppData(this.mNativeObject, str, str2, i);
        }
    }

    public void setDebugMonitor(boolean z, int i) {
        if (0 != this.mNativeObject) {
            setDebugMonitor(this.mNativeObject, z, i);
        }
    }

    public int startNative(String str, int i, String str2) {
        if (0 != this.mNativeObject) {
            return startNative(this.mNativeObject, str, i, str2);
        }
        return -1;
    }

    public int stopNative() {
        if (0 != this.mNativeObject) {
            return stopNative(this.mNativeObject);
        }
        return -1;
    }

    public int restartNative(String str) {
        if (0 != this.mNativeObject) {
            return restartNative(this.mNativeObject, str);
        }
        return -1;
    }

    public int sendAACDataNative(byte[] bArr, int i) {
        if (0 != this.mNativeObject) {
            return sendAACDataNative(this.mNativeObject, bArr, i);
        }
        return -1;
    }

    public int sendPCMDataNative(byte[] bArr, int i) {
        if (0 != this.mNativeObject) {
            return sendPCMDataNative(this.mNativeObject, bArr, i);
        }
        return -1;
    }

    public int sendPCMDataNative2(byte[] bArr, int i) {
        if (0 != this.mNativeObject) {
            return sendPCMDataNative2(this.mNativeObject, bArr, i);
        }
        return -1;
    }

    public int sendH264DataNative(byte[] bArr, int i, String str, long j) {
        if (0 != this.mNativeObject) {
            return sendH264DataNative(this.mNativeObject, bArr, i, str, j);
        }
        return -1;
    }

    public int sendYuvDataNative(byte[] bArr, int i, int i2, int i3, boolean z, byte[] bArr2, Integer num, String str) {
        if (0 != this.mNativeObject) {
            return sendYuvDataNative(this.mNativeObject, bArr, i, i2, i3, z, bArr2, num, str);
        }
        return -1;
    }

    public String getPushStreamIpNative() {
        if (0 != this.mNativeObject) {
            return getPushStreamIpNative(this.mNativeObject);
        }
        return null;
    }

    public void networkChangedNotifyNative(int i) {
        if (0 != this.mNativeObject) {
            networkChangedNotifyNative(this.mNativeObject, i);
        }
    }

    public float getStreamStateNative(Integer num, Integer num2) {
        if (0 != this.mNativeObject) {
            return getStreamStateNative(this.mNativeObject, num, num2);
        }
        return 0.0f;
    }

    public int updateVCodeParamNative(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (0 != this.mNativeObject) {
            return updateVCodeParamNative(this.mNativeObject, i, i2, i3, i4, i5, i6, i7, i8);
        }
        return -1;
    }

    public void syncStatConfig(String str, String str2, int i) {
        if (0 != this.mNativeObject) {
            syncStatConfig(this.mNativeObject, str, str2, i);
        }
    }

    public int initPKPlayer(Object obj) {
        if (0 != this.mNativeObject) {
            return initPKPlayer(this.mNativeObject, obj);
        }
        return -1;
    }

    public int videoFrameNV21ToRGBA(byte[] bArr, int i, int i2, int i3, byte[] bArr2) {
        if (0 != this.mNativeObject) {
            return nV21ToRGBA(this.mNativeObject, bArr, i, i2, i3, bArr2);
        }
        return -1;
    }

    public int initAudioReSample(int i, int i2, int i3) {
        if (0 != this.mNativeObject) {
            return initAudioReSample(this.mNativeObject, i, i2, i3);
        }
        return -1;
    }

    public int setRtcConfig(int i, int i2, int i3, int i4) {
        if (0 != this.mNativeObject) {
            return setRtcConfig(this.mNativeObject, i, i2, i3, i4);
        }
        return -1;
    }

    private void registerNativeObject(long j) {
        setNativeObject(j);
    }

    private void rtmpResponsedCallback(int i, int i2, int i3) {
        if (this.mCallback != null) {
            this.mCallback.rtmpResponsedCallback(i, i2, i3);
        }
    }

    private void rtmpDebugResponsedCallback(AlaLiveDebugInfo alaLiveDebugInfo) {
        if (this.mCallback != null) {
            this.mCallback.rtmpDebugResponsedCallback(alaLiveDebugInfo);
        }
    }

    private void onRemoteUserOnLine(int i, long j, int i2) {
        if (this.mCallback != null) {
            this.mCallback.onRemoteUserOnLine(i, j, i2);
        }
    }
}
