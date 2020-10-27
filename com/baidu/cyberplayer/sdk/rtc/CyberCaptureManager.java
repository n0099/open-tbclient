package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.d;
@Keep
/* loaded from: classes12.dex */
public class CyberCaptureManager {

    /* renamed from: a  reason: collision with root package name */
    private CaptureManagerProvider f1415a;

    @Keep
    /* loaded from: classes12.dex */
    public interface OnCaptureReadyCallback {
        void onVideoCaptureReady(boolean z);
    }

    public CyberCaptureManager(Context context, int i, int i2, int i3, int i4, int i5, boolean z) {
        this.f1415a = a.a().a(context, i, i2, i3, i4, i5, z);
    }

    public static void enableDebug(boolean z) {
        d.b(z);
    }

    public void destroySurface() {
        if (this.f1415a != null) {
            this.f1415a.destroySurface();
        }
    }

    public void doAutoFocus() {
        if (this.f1415a != null) {
            this.f1415a.doAutoFocus();
        }
    }

    public void doFocus(int i, int i2, int i3, int i4) {
        if (this.f1415a != null) {
            this.f1415a.doFocus(i, i2, i3, i4);
        }
    }

    public void enableZoom(boolean z) {
        if (this.f1415a != null) {
            this.f1415a.enableZoom(z);
        }
    }

    public boolean isFrontCamera() {
        if (this.f1415a != null) {
            return this.f1415a.isFrontCamera();
        }
        return false;
    }

    public void muteCamera(boolean z) {
        if (this.f1415a != null) {
            this.f1415a.muteCamera(z);
        }
    }

    public void pause() {
        if (this.f1415a != null) {
            this.f1415a.pause();
        }
    }

    public void release() {
        if (this.f1415a != null) {
            this.f1415a.release();
        }
    }

    public void resume() {
        if (this.f1415a != null) {
            this.f1415a.resume();
        }
    }

    public void setBeautyBlure(float f) {
        if (this.f1415a != null) {
            this.f1415a.setBeautyBlure(f);
        }
    }

    public void setBeautyWhite(float f) {
        if (this.f1415a != null) {
            this.f1415a.setBeautyWhite(f);
        }
    }

    public void setCameraFace(boolean z) {
        if (this.f1415a != null) {
            this.f1415a.setCameraFace(z);
        }
    }

    public void setCaptureReadyCallback(OnCaptureReadyCallback onCaptureReadyCallback) {
        if (this.f1415a != null) {
            this.f1415a.setCaptureReadyCallback(onCaptureReadyCallback);
        }
    }

    public void setCheekThin(float f) {
        if (this.f1415a != null) {
            this.f1415a.setCheekThin(f);
        }
    }

    public void setEnlargeEye(float f) {
        if (this.f1415a != null) {
            this.f1415a.setEnlargeEye(f);
        }
    }

    public void setFlip(boolean z) {
        if (this.f1415a != null) {
            this.f1415a.setFlip(z);
        }
    }

    public void setRtcExternalCapture(CyberRTCRoom cyberRTCRoom) {
        if (this.f1415a != null) {
            this.f1415a.setRtcExternalCapture(cyberRTCRoom.getProvider());
        }
    }

    public void setRtcRemoteFlip(boolean z) {
        if (this.f1415a != null) {
            this.f1415a.setRtcRemoteFlip(z);
        }
    }

    public void setSurface(Surface surface) {
        if (this.f1415a != null) {
            this.f1415a.setSurface(surface);
        }
    }

    public void setSurfaceSize(int i, int i2) {
        if (this.f1415a != null) {
            this.f1415a.setSurfaceSize(i, i2);
        }
    }

    public void switchCamera() {
        if (this.f1415a != null) {
            this.f1415a.switchCamera();
        }
    }

    public void zoom(int i) {
        if (this.f1415a != null) {
            this.f1415a.zoom(i);
        }
    }
}
