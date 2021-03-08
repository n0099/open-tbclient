package com.baidu.rtc;

import android.content.Context;
import android.util.AttributeSet;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes9.dex */
public class RTCVideoView extends SurfaceViewRenderer {
    private boolean cwE;
    private volatile boolean cwM;
    private VideoSink cwN;
    private Runnable cwO;
    private com.baidu.rtc.b.f stuckDataCalculator;

    /* loaded from: classes9.dex */
    public interface a extends VideoSink {
    }

    public RTCVideoView(Context context) {
        super(context);
        this.cwM = false;
        this.stuckDataCalculator = new com.baidu.rtc.b.f(600);
        this.cwE = false;
        this.cwO = null;
        this.cwN = null;
    }

    public RTCVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cwM = false;
        this.stuckDataCalculator = new com.baidu.rtc.b.f(600);
        this.cwE = false;
        this.cwO = null;
        this.cwN = null;
    }

    public boolean aeS() {
        return false;
    }

    public void b(l lVar) {
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void clearImage() {
        this.stuckDataCalculator.reset();
        if (this.cwN != null) {
            return;
        }
        super.clearImage();
    }

    @Override // org.webrtc.SurfaceViewRenderer, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.cwE) {
            this.stuckDataCalculator.afx();
        }
        if (this.cwO != null) {
            this.cwO.run();
            this.cwO = null;
        }
        if (this.cwN != null) {
            if (!this.cwM) {
                this.cwN.onFrame(videoFrame);
                return;
            }
            this.cwN.onFrame(l.a(videoFrame));
        }
        if (aeS()) {
            b(l.a(videoFrame));
        } else {
            super.onFrame(videoFrame);
        }
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setEnableHardwareScaler(boolean z) {
        if (this.cwN != null) {
            return;
        }
        super.setEnableHardwareScaler(z);
    }

    public void setEnableSLIDataReport(boolean z) {
        this.cwE = z;
    }

    public void setExtVideoSink(a aVar) {
        this.cwN = aVar;
    }

    public void setExtVideoSink(VideoSink videoSink, boolean z) {
        this.cwN = videoSink;
        this.cwM = z;
    }

    public void setFirstFrameEventListener(Runnable runnable) {
        this.cwO = runnable;
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setMirror(boolean z) {
        if (this.cwN != null) {
            return;
        }
        super.setMirror(z);
    }

    public void setStuckEventListener(com.baidu.rtc.b.e eVar) {
        this.stuckDataCalculator.setStuckEventListener(eVar);
    }
}
