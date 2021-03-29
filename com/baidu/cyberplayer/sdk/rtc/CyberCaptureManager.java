package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.d;
@Keep
/* loaded from: classes.dex */
public class CyberCaptureManager {

    /* renamed from: a  reason: collision with root package name */
    public CaptureManagerProvider f5042a;

    @Keep
    /* loaded from: classes.dex */
    public interface OnCaptureReadyCallback {
        void onVideoCaptureReady(boolean z);
    }

    public CyberCaptureManager(Context context, int i, int i2, int i3, int i4, int i5, boolean z) {
        this.f5042a = a.a().a(context, i, i2, i3, i4, i5, z);
    }

    public static void enableDebug(boolean z) {
        d.b(z);
    }

    public void destroySurface() {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.destroySurface();
        }
    }

    public void doAutoFocus() {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.doAutoFocus();
        }
    }

    public void doFocus(int i, int i2, int i3, int i4) {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.doFocus(i, i2, i3, i4);
        }
    }

    public void enableZoom(boolean z) {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.enableZoom(z);
        }
    }

    public boolean isFrontCamera() {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            return captureManagerProvider.isFrontCamera();
        }
        return false;
    }

    public void muteCamera(boolean z) {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.muteCamera(z);
        }
    }

    public void pause() {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.pause();
        }
    }

    public void release() {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.release();
        }
    }

    public void resume() {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.resume();
        }
    }

    public void setBeautyBlure(float f2) {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.setBeautyBlure(f2);
        }
    }

    public void setBeautyWhite(float f2) {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.setBeautyWhite(f2);
        }
    }

    public void setCameraFace(boolean z) {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.setCameraFace(z);
        }
    }

    public void setCaptureReadyCallback(OnCaptureReadyCallback onCaptureReadyCallback) {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.setCaptureReadyCallback(onCaptureReadyCallback);
        }
    }

    public void setCheekThin(float f2) {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.setCheekThin(f2);
        }
    }

    public void setEnlargeEye(float f2) {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.setEnlargeEye(f2);
        }
    }

    public void setFlip(boolean z) {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.setFlip(z);
        }
    }

    public void setRtcExternalCapture(CyberRTCRoom cyberRTCRoom) {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.setRtcExternalCapture(cyberRTCRoom.getProvider());
        }
    }

    public void setRtcRemoteFlip(boolean z) {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.setRtcRemoteFlip(z);
        }
    }

    public void setSurface(Surface surface) {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.setSurface(surface);
        }
    }

    public void setSurfaceSize(int i, int i2) {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.setSurfaceSize(i, i2);
        }
    }

    public void switchCamera() {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.switchCamera();
        }
    }

    public void zoom(int i) {
        CaptureManagerProvider captureManagerProvider = this.f5042a;
        if (captureManagerProvider != null) {
            captureManagerProvider.zoom(i);
        }
    }
}
