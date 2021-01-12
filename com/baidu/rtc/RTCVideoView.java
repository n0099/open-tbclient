package com.baidu.rtc;

import android.content.Context;
import android.util.AttributeSet;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes9.dex */
public class RTCVideoView extends SurfaceViewRenderer {
    private volatile boolean ctm;
    private VideoSink ctn;
    private Runnable cto;

    /* loaded from: classes9.dex */
    public interface a extends VideoSink {
    }

    public RTCVideoView(Context context) {
        super(context);
        this.ctm = false;
        this.cto = null;
        this.ctn = null;
    }

    public RTCVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ctm = false;
        this.cto = null;
        this.ctn = null;
    }

    public boolean aew() {
        return false;
    }

    public void b(l lVar) {
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void clearImage() {
        if (this.ctn != null) {
            return;
        }
        super.clearImage();
    }

    @Override // org.webrtc.SurfaceViewRenderer, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.cto != null) {
            this.cto.run();
            this.cto = null;
        }
        if (this.ctn != null) {
            if (!this.ctm) {
                this.ctn.onFrame(videoFrame);
                return;
            }
            this.ctn.onFrame(l.a(videoFrame));
        }
        if (aew()) {
            b(l.a(videoFrame));
        } else {
            super.onFrame(videoFrame);
        }
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setEnableHardwareScaler(boolean z) {
        if (this.ctn != null) {
            return;
        }
        super.setEnableHardwareScaler(z);
    }

    public void setExtVideoSink(a aVar) {
        this.ctn = aVar;
    }

    public void setExtVideoSink(VideoSink videoSink, boolean z) {
        this.ctn = videoSink;
        this.ctm = z;
    }

    public void setFirstFrameEventListener(Runnable runnable) {
        this.cto = runnable;
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setMirror(boolean z) {
        if (this.ctn != null) {
            return;
        }
        super.setMirror(z);
    }
}
