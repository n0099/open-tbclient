package com.baidu.ala.ndk;
/* loaded from: classes14.dex */
public class AlaNDKPlayerAdapter {
    private volatile long mNativeObject = 0;

    private native int createSurfaceNative(long j, int i, Object obj);

    private native int destroySurfaceNative(long j, int i);

    private native void enterBackground(long j);

    private native void enterForeground(long j);

    private native int getAudioPCMNative(long j, byte[] bArr);

    private native String getPullStreamIpNative(long j, int i);

    private native int getVideoFillModel(long j, int i);

    private native int initNative(Object obj);

    private native void networkChangedNotifyNative(long j, int i);

    private native int restartNative(long j, int i, int i2);

    private native void sendNativeStatAppData(long j, int i, String str, String str2, int i2);

    private native void setDebugMonitorNative(long j, int i, boolean z, int i2);

    private native void setPauseNative(long j, int i, int i2);

    private native void setVideoFillModel(long j, int i, int i2);

    private native int setWebRtcHandle(long j, long j2);

    private native int startNative(long j, String str, int i, int i2, String str2);

    private native int stopNative(long j, int i);

    private native int surfaceChangedNative(long j, int i, int i2, int i3, Object obj);

    private native void syncStatConfig(long j, String str, String str2, int i);

    public void setNativeObject(long j) {
        this.mNativeObject = j;
    }

    public long getNativeObject() {
        return this.mNativeObject;
    }

    public int initPlayerNative(Object obj) {
        return initNative(obj);
    }

    public int startPlayerNative(String str, int i, int i2, String str2) {
        if (this.mNativeObject != 0) {
            return startNative(this.mNativeObject, str, i, i2, str2);
        }
        return -1;
    }

    public void enterBackground() {
        if (this.mNativeObject != 0) {
            enterBackground(this.mNativeObject);
        }
    }

    public void enterForeground() {
        if (this.mNativeObject != 0) {
            enterForeground(this.mNativeObject);
        }
    }

    public void setVideoFillModel(int i, int i2) {
        if (this.mNativeObject != 0) {
            setVideoFillModel(this.mNativeObject, i, i2);
        }
    }

    public int getVideoFillModel(int i) {
        if (this.mNativeObject != 0) {
            return getVideoFillModel(this.mNativeObject, i);
        }
        return 0;
    }

    public void sendNativeStatAppData(int i, String str, String str2, int i2) {
        if (this.mNativeObject != 0) {
            sendNativeStatAppData(this.mNativeObject, i, str, str2, i2);
        }
    }

    public void syncStatConfig(String str, String str2, int i) {
        if (this.mNativeObject != 0) {
            syncStatConfig(this.mNativeObject, str, str2, i);
        }
    }

    public int stopNative(int i) {
        if (this.mNativeObject != 0) {
            return stopNative(this.mNativeObject, i);
        }
        return 0;
    }

    public int restartNative(int i, int i2) {
        if (this.mNativeObject != 0) {
            return restartNative(this.mNativeObject, i, i2);
        }
        return 0;
    }

    public void setDebugMonitor(int i, boolean z, int i2) {
        if (this.mNativeObject != 0) {
            setDebugMonitorNative(this.mNativeObject, i, z, i2);
        }
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

    public String getPullStreamIpNative(int i) {
        if (this.mNativeObject != 0) {
            return getPullStreamIpNative(this.mNativeObject, i);
        }
        return null;
    }

    public void networkChangedNotifyNative(int i) {
        if (this.mNativeObject != 0) {
            networkChangedNotifyNative(this.mNativeObject, i);
        }
    }

    public int setWebRtcHandle(long j) {
        setWebRtcHandle(this.mNativeObject, j);
        return 0;
    }

    public void setPause(int i, boolean z) {
        setPauseNative(this.mNativeObject, i, z ? 1 : 0);
    }
}
