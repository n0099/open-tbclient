package com.baidu.rtc;

import android.content.Context;
import android.util.AttributeSet;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes10.dex */
public class RTCVideoView extends SurfaceViewRenderer {
    private boolean cve;
    private volatile boolean cvm;
    private VideoSink cvn;
    private Runnable cvo;
    private com.baidu.rtc.b.f stuckDataCalculator;

    /* loaded from: classes10.dex */
    public interface a extends VideoSink {
    }

    public RTCVideoView(Context context) {
        super(context);
        this.cvm = false;
        this.stuckDataCalculator = new com.baidu.rtc.b.f(600);
        this.cve = false;
        this.cvo = null;
        this.cvn = null;
    }

    public RTCVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvm = false;
        this.stuckDataCalculator = new com.baidu.rtc.b.f(600);
        this.cve = false;
        this.cvo = null;
        this.cvn = null;
    }

    public boolean aeP() {
        return false;
    }

    public void b(l lVar) {
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void clearImage() {
        this.stuckDataCalculator.reset();
        if (this.cvn != null) {
            return;
        }
        super.clearImage();
    }

    @Override // org.webrtc.SurfaceViewRenderer, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.cve) {
            this.stuckDataCalculator.afu();
        }
        if (this.cvo != null) {
            this.cvo.run();
            this.cvo = null;
        }
        if (this.cvn != null) {
            if (!this.cvm) {
                this.cvn.onFrame(videoFrame);
                return;
            }
            this.cvn.onFrame(l.a(videoFrame));
        }
        if (aeP()) {
            b(l.a(videoFrame));
        } else {
            super.onFrame(videoFrame);
        }
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setEnableHardwareScaler(boolean z) {
        if (this.cvn != null) {
            return;
        }
        super.setEnableHardwareScaler(z);
    }

    public void setEnableSLIDataReport(boolean z) {
        this.cve = z;
    }

    public void setExtVideoSink(a aVar) {
        this.cvn = aVar;
    }

    public void setExtVideoSink(VideoSink videoSink, boolean z) {
        this.cvn = videoSink;
        this.cvm = z;
    }

    public void setFirstFrameEventListener(Runnable runnable) {
        this.cvo = runnable;
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setMirror(boolean z) {
        if (this.cvn != null) {
            return;
        }
        super.setMirror(z);
    }

    public void setStuckEventListener(com.baidu.rtc.b.e eVar) {
        this.stuckDataCalculator.setStuckEventListener(eVar);
    }
}
