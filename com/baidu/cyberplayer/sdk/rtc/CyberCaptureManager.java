package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreInvoker;
import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes3.dex */
public class CyberCaptureManager {
    public static final String TAG = "CyberCaptureManager";
    public CaptureManagerProvider provider;

    @Keep
    /* loaded from: classes3.dex */
    public interface OnCaptureReadyCallback {
        void onVideoCaptureReady(boolean z);
    }

    public CyberCaptureManager(Context context, int i, int i2, int i3, int i4, int i5, boolean z) {
        this.provider = RTCProviderFactory.getInstance().createCaptureManager(context, i, i2, i3, i4, i5, z);
    }

    public static void enableDebug(boolean z) {
        CyberPlayerCoreInvoker.enableRTCCaptureDebug(z);
    }

    public void enableZoom(boolean z) {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.enableZoom(z);
        }
    }

    public void muteCamera(boolean z) {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.muteCamera(z);
        }
    }

    public void setBeautyBlure(float f) {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.setBeautyBlure(f);
        }
    }

    public void setBeautyWhite(float f) {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.setBeautyWhite(f);
        }
    }

    public void setCameraFace(boolean z) {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.setCameraFace(z);
        }
    }

    public void setCaptureReadyCallback(OnCaptureReadyCallback onCaptureReadyCallback) {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.setCaptureReadyCallback(onCaptureReadyCallback);
        }
    }

    public void setCheekThin(float f) {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.setCheekThin(f);
        }
    }

    public void setEnlargeEye(float f) {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.setEnlargeEye(f);
        }
    }

    public void setFlip(boolean z) {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.setFlip(z);
        }
    }

    public void setRtcExternalCapture(CyberRTCRoom cyberRTCRoom) {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.setRtcExternalCapture(cyberRTCRoom.getProvider());
        }
    }

    public void setRtcRemoteFlip(boolean z) {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.setRtcRemoteFlip(z);
        }
    }

    public void setSurface(Surface surface) {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.setSurface(surface);
        }
    }

    public void zoom(int i) {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.zoom(i);
        }
    }

    public void destroySurface() {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.destroySurface();
        }
    }

    public void doAutoFocus() {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.doAutoFocus();
        }
    }

    public boolean isFrontCamera() {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            return captureManagerProvider.isFrontCamera();
        }
        return false;
    }

    public void pause() {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.pause();
        }
    }

    public void release() {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.release();
        }
    }

    public void resume() {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.resume();
        }
    }

    public void switchCamera() {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.switchCamera();
        }
    }

    public void doFocus(int i, int i2, int i3, int i4) {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.doFocus(i, i2, i3, i4);
        }
    }

    public void setSurfaceSize(int i, int i2) {
        CaptureManagerProvider captureManagerProvider = this.provider;
        if (captureManagerProvider != null) {
            captureManagerProvider.setSurfaceSize(i, i2);
        }
    }
}
