package com.baidu.rtc;

import android.content.Context;
import org.webrtc.CapturerObserver;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoCapturer;
/* loaded from: classes2.dex */
public abstract class RTCVideoCapture implements VideoCapturer {
    public CapturerObserver innnerCapturerObserver = null;
    public RTCCapturerObserver outterCapturerObserver = new RTCCapturerObserver() { // from class: com.baidu.rtc.RTCVideoCapture.1
        @Override // com.baidu.rtc.RTCVideoCapture.RTCCapturerObserver
        public void onCapturerStarted(boolean z) {
            RTCVideoCapture.this.innnerCapturerObserver.onCapturerStarted(z);
        }

        @Override // com.baidu.rtc.RTCVideoCapture.RTCCapturerObserver
        public void onCapturerStopped() {
            RTCVideoCapture.this.innnerCapturerObserver.onCapturerStopped();
        }

        @Override // com.baidu.rtc.RTCVideoCapture.RTCCapturerObserver
        public void onFrameCaptured(RTCVideoFrame rTCVideoFrame) {
            RTCVideoCapture.this.innnerCapturerObserver.onFrameCaptured(rTCVideoFrame);
        }
    };

    /* loaded from: classes2.dex */
    public interface RTCCapturerObserver {
        void onCapturerStarted(boolean z);

        void onCapturerStopped();

        void onFrameCaptured(RTCVideoFrame rTCVideoFrame);
    }

    @Override // org.webrtc.VideoCapturer
    public void changeCaptureFormat(int i2, int i3, int i4) {
    }

    @Override // org.webrtc.VideoCapturer
    public void dispose() {
    }

    public abstract void initialize(RTCCapturerObserver rTCCapturerObserver);

    @Override // org.webrtc.VideoCapturer
    public void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        this.innnerCapturerObserver = capturerObserver;
        initialize(this.outterCapturerObserver);
    }

    @Override // org.webrtc.VideoCapturer
    public boolean isScreencast() {
        return false;
    }

    @Override // org.webrtc.VideoCapturer
    public void startCapture(int i2, int i3, int i4) {
    }

    @Override // org.webrtc.VideoCapturer
    public void stopCapture() {
    }
}
