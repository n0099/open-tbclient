package com.baidu.ala.ndk;
/* loaded from: classes12.dex */
public class AlaNDKPKPlayerAdapter {
    private volatile long mNativeObject = 0;

    private native int createSurfaceNative(long j, int i, Object obj);

    private native int destroySurfaceNative(long j, int i);

    private native int getAudioPCMNative(long j, byte[] bArr);

    private native int setWebRtcHandle(long j, long j2);

    private native int startNative(long j, String str, int i, int i2, String str2);

    private native int stopNative(long j, int i);

    private native int surfaceChangedNative(long j, int i, int i2, int i3, Object obj);

    public void setNativeObject(long j) {
        this.mNativeObject = j;
    }

    public long getNativeObject() {
        return this.mNativeObject;
    }

    public int startPlayerNative(String str, int i, int i2, String str2) {
        if (this.mNativeObject != 0) {
            return startNative(this.mNativeObject, str, i, i2, str2);
        }
        return -1;
    }

    public int stopNative(int i) {
        if (this.mNativeObject != 0) {
            return stopNative(this.mNativeObject, i);
        }
        return 0;
    }

    public int setWebRtcHandle(long j) {
        setWebRtcHandle(this.mNativeObject, j);
        return 0;
    }

    public int getAudioPCMNative(byte[] bArr) {
        if (this.mNativeObject != 0) {
            return getAudioPCMNative(this.mNativeObject, bArr);
        }
        return -1;
    }

    public int createSurfaceNative(int i, Object obj) {
        if (this.mNativeObject != 0) {
            return createSurfaceNative(this.mNativeObject, i, obj);
        }
        return 0;
    }

    public int surfaceChangedNative(int i, int i2, int i3, Object obj) {
        if (this.mNativeObject != 0) {
            return surfaceChangedNative(this.mNativeObject, i, i2, i3, obj);
        }
        return 0;
    }

    public int destroySurfaceNative(int i) {
        if (this.mNativeObject != 0) {
            return destroySurfaceNative(this.mNativeObject, i);
        }
        return 0;
    }
}
