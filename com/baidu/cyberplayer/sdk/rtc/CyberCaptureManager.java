package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.d;
@Keep
/* loaded from: classes7.dex */
public class CyberCaptureManager {
    private CaptureManagerProvider a;

    @Keep
    /* loaded from: classes7.dex */
    public interface OnCaptureReadyCallback {
        void onVideoCaptureReady(boolean z);
    }

    public CyberCaptureManager(Context context, int i, int i2, int i3, int i4, int i5, boolean z) {
        this.a = a.a().a(context, i, i2, i3, i4, i5, z);
    }

    public static void enableDebug(boolean z) {
        d.b(z);
    }

    public void destroySurface() {
        if (this.a != null) {
            this.a.destroySurface();
        }
    }

    public void doAutoFocus() {
        if (this.a != null) {
            this.a.doAutoFocus();
        }
    }

    public void doFocus(int i, int i2, int i3, int i4) {
        if (this.a != null) {
            this.a.doFocus(i, i2, i3, i4);
        }
    }

    public void enableZoom(boolean z) {
        if (this.a != null) {
            this.a.enableZoom(z);
        }
    }

    public boolean isFrontCamera() {
        if (this.a != null) {
            return this.a.isFrontCamera();
        }
        return false;
    }

    public void muteCamera(boolean z) {
        if (this.a != null) {
            this.a.muteCamera(z);
        }
    }

    public void pause() {
        if (this.a != null) {
            this.a.pause();
        }
    }

    public void release() {
        if (this.a != null) {
            this.a.release();
        }
    }

    public void resume() {
        if (this.a != null) {
            this.a.resume();
        }
    }

    public void setBeautyBlure(float f) {
        if (this.a != null) {
            this.a.setBeautyBlure(f);
        }
    }

    public void setBeautyWhite(float f) {
        if (this.a != null) {
            this.a.setBeautyWhite(f);
        }
    }

    public void setCameraFace(boolean z) {
        if (this.a != null) {
            this.a.setCameraFace(z);
        }
    }

    public void setCaptureReadyCallback(OnCaptureReadyCallback onCaptureReadyCallback) {
        if (this.a != null) {
            this.a.setCaptureReadyCallback(onCaptureReadyCallback);
        }
    }

    public void setCheekThin(float f) {
        if (this.a != null) {
            this.a.setCheekThin(f);
        }
    }

    public void setEnlargeEye(float f) {
        if (this.a != null) {
            this.a.setEnlargeEye(f);
        }
    }

    public void setFlip(boolean z) {
        if (this.a != null) {
            this.a.setFlip(z);
        }
    }

    public void setRtcExternalCapture(CyberRTCRoom cyberRTCRoom) {
        if (this.a != null) {
            this.a.setRtcExternalCapture(cyberRTCRoom.getProvider());
        }
    }

    public void setRtcRemoteFlip(boolean z) {
        if (this.a != null) {
            this.a.setRtcRemoteFlip(z);
        }
    }

    public void setSurface(Surface surface) {
        if (this.a != null) {
            this.a.setSurface(surface);
        }
    }

    public void setSurfaceSize(int i, int i2) {
        if (this.a != null) {
            this.a.setSurfaceSize(i, i2);
        }
    }

    public void switchCamera() {
        if (this.a != null) {
            this.a.switchCamera();
        }
    }

    public void zoom(int i) {
        if (this.a != null) {
            this.a.zoom(i);
        }
    }
}
