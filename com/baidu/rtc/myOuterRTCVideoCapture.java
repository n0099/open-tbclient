package com.baidu.rtc;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.rtc.RTCVideoCapture;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class myOuterRTCVideoCapture extends RTCVideoCapture {
    public RTCVideoCapture.RTCCapturerObserver capturerObserver = null;
    public final int frameWidth = 480;
    public final int frameHeight = 640;
    public final Timer timer = new Timer();
    public final TimerTask tickTask = new TimerTask() { // from class: com.baidu.rtc.myOuterRTCVideoCapture.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            myOuterRTCVideoCapture.this.tick();
        }
    };

    @Override // com.baidu.rtc.RTCVideoCapture, org.webrtc.VideoCapturer
    public void changeCaptureFormat(int i2, int i3, int i4) {
    }

    @Override // com.baidu.rtc.RTCVideoCapture, org.webrtc.VideoCapturer
    public void dispose() {
    }

    public RTCVideoFrame getNextFrame() {
        long nanos = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
        RTCI420Buffer allocate = RTCI420Buffer.allocate(480, 640);
        allocate.getDataY();
        allocate.getDataU();
        allocate.getDataV();
        allocate.getStrideY();
        allocate.getStrideU();
        allocate.getStrideV();
        return new RTCVideoFrame(allocate, 0, nanos);
    }

    @Override // com.baidu.rtc.RTCVideoCapture
    public void initialize(RTCVideoCapture.RTCCapturerObserver rTCCapturerObserver) {
        this.capturerObserver = rTCCapturerObserver;
    }

    @Override // com.baidu.rtc.RTCVideoCapture, org.webrtc.VideoCapturer
    public boolean isScreencast() {
        return false;
    }

    @Override // com.baidu.rtc.RTCVideoCapture, org.webrtc.VideoCapturer
    public void startCapture(int i2, int i3, int i4) {
        Log.e("selfVideoCapture", "startCapture.");
        this.timer.schedule(this.tickTask, 0L, 66L);
    }

    @Override // com.baidu.rtc.RTCVideoCapture, org.webrtc.VideoCapturer
    public void stopCapture() {
        this.timer.cancel();
    }

    public void tick() {
        RTCVideoFrame nextFrame = getNextFrame();
        this.capturerObserver.onFrameCaptured(nextFrame);
        nextFrame.release();
    }
}
