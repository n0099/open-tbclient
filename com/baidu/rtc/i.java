package com.baidu.rtc;

import android.content.Context;
import org.webrtc.CapturerObserver;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoCapturer;
/* loaded from: classes9.dex */
public abstract class i implements VideoCapturer {
    private CapturerObserver ctc = null;
    private a ctd = new a() { // from class: com.baidu.rtc.i.1
        @Override // com.baidu.rtc.i.a
        public void a(l lVar) {
            i.this.ctc.onFrameCaptured(lVar);
        }
    };

    /* loaded from: classes9.dex */
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
        this.ctc = capturerObserver;
        a(this.ctd);
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
