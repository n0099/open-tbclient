package com.baidu.cyberplayer.sdk.rtc;

import android.view.Surface;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.rtc.CyberCaptureManager;
@Keep
/* loaded from: classes.dex */
public abstract class CaptureManagerProvider {
    public abstract void destroySurface();

    public abstract void doAutoFocus();

    public abstract void doFocus(int i, int i2, int i3, int i4);

    public abstract void enableZoom(boolean z);

    public abstract boolean isFrontCamera();

    public abstract void muteCamera(boolean z);

    public abstract void pause();

    public abstract void release();

    public abstract void resume();

    public abstract void setBeautyBlure(float f2);

    public abstract void setBeautyWhite(float f2);

    public abstract void setCameraFace(boolean z);

    public abstract void setCaptureReadyCallback(CyberCaptureManager.OnCaptureReadyCallback onCaptureReadyCallback);

    public abstract void setCheekThin(float f2);

    public abstract void setEnlargeEye(float f2);

    public abstract void setFlip(boolean z);

    public abstract void setRtcExternalCapture(RTCRoomProvider rTCRoomProvider);

    public abstract void setRtcRemoteFlip(boolean z);

    public abstract void setSurface(Surface surface);

    public abstract void setSurfaceSize(int i, int i2);

    public abstract void switchCamera();

    public abstract void zoom(int i);
}
