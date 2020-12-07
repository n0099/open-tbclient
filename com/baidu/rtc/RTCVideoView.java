package com.baidu.rtc;

import android.content.Context;
import android.util.AttributeSet;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes12.dex */
public class RTCVideoView extends SurfaceViewRenderer {
    private volatile boolean cqY;
    private VideoSink cqZ;
    private Runnable cra;

    /* loaded from: classes12.dex */
    public interface a extends VideoSink {
    }

    public RTCVideoView(Context context) {
        super(context);
        this.cqY = false;
        this.cra = null;
        this.cqZ = null;
    }

    public RTCVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cqY = false;
        this.cra = null;
        this.cqZ = null;
    }

    public boolean agt() {
        return false;
    }

    public void b(l lVar) {
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void clearImage() {
        if (this.cqZ != null) {
            return;
        }
        super.clearImage();
    }

    @Override // org.webrtc.SurfaceViewRenderer, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.cra != null) {
            this.cra.run();
            this.cra = null;
        }
        if (this.cqZ != null) {
            if (!this.cqY) {
                this.cqZ.onFrame(videoFrame);
                return;
            }
            this.cqZ.onFrame(l.a(videoFrame));
        }
        if (agt()) {
            b(l.a(videoFrame));
        } else {
            super.onFrame(videoFrame);
        }
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setEnableHardwareScaler(boolean z) {
        if (this.cqZ != null) {
            return;
        }
        super.setEnableHardwareScaler(z);
    }

    public void setExtVideoSink(a aVar) {
        this.cqZ = aVar;
    }

    public void setExtVideoSink(VideoSink videoSink, boolean z) {
        this.cqZ = videoSink;
        this.cqY = z;
    }

    public void setFirstFrameEventListener(Runnable runnable) {
        this.cra = runnable;
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setMirror(boolean z) {
        if (this.cqZ != null) {
            return;
        }
        super.setMirror(z);
    }
}
