package com.baidu.rtc;

import android.content.Context;
import org.webrtc.CapturerObserver;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoCapturer;
/* loaded from: classes16.dex */
public abstract class i implements VideoCapturer {
    private CapturerObserver ckb = null;
    private a ckc = new a() { // from class: com.baidu.rtc.i.1
        @Override // com.baidu.rtc.i.a
        public void a(l lVar) {
            i.this.ckb.onFrameCaptured(lVar);
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void a(l lVar);
    }

    public abstract void a(a aVar);

    @Override // org.webrtc.VideoCapturer
    public void changeCaptureFormat(int i, int i2, int i3) {
    }

    @Override // org.webrtc.VideoCapturer
    public void dispose() {
    }

    @Override // org.webrtc.VideoCapturer
    public void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        this.ckb = capturerObserver;
        a(this.ckc);
    }

    @Override // org.webrtc.VideoCapturer
    public boolean isScreencast() {
        return false;
    }

    @Override // org.webrtc.VideoCapturer
    public void startCapture(int i, int i2, int i3) {
    }

    @Override // org.webrtc.VideoCapturer
    public void stopCapture() {
    }
}
