package com.baidu.rtc;

import android.content.Context;
import android.util.AttributeSet;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes9.dex */
public class RTCVideoView extends SurfaceViewRenderer {
    private volatile boolean cgf;
    private VideoSink cgg;
    private Runnable cgh;

    /* loaded from: classes9.dex */
    public interface a extends VideoSink {
    }

    public RTCVideoView(Context context) {
        super(context);
        this.cgf = false;
        this.cgh = null;
        this.cgg = null;
    }

    public RTCVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cgf = false;
        this.cgh = null;
        this.cgg = null;
    }

    public boolean abs() {
        return false;
    }

    public void b(l lVar) {
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void clearImage() {
        if (this.cgg != null) {
            return;
        }
        super.clearImage();
    }

    @Override // org.webrtc.SurfaceViewRenderer, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.cgh != null) {
            this.cgh.run();
            this.cgh = null;
        }
        if (this.cgg != null) {
            if (!this.cgf) {
                this.cgg.onFrame(videoFrame);
                return;
            }
            this.cgg.onFrame(l.a(videoFrame));
        }
        if (abs()) {
            b(l.a(videoFrame));
        } else {
            super.onFrame(videoFrame);
        }
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setEnableHardwareScaler(boolean z) {
        if (this.cgg != null) {
            return;
        }
        super.setEnableHardwareScaler(z);
    }

    public void setExtVideoSink(a aVar) {
        this.cgg = aVar;
    }

    public void setExtVideoSink(VideoSink videoSink, boolean z) {
        this.cgg = videoSink;
        this.cgf = z;
    }

    public void setFirstFrameEventListener(Runnable runnable) {
        this.cgh = runnable;
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setMirror(boolean z) {
        if (this.cgg != null) {
            return;
        }
        super.setMirror(z);
    }
}
