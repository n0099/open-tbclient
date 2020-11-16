package com.baidu.rtc;

import android.content.Context;
import android.util.AttributeSet;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes16.dex */
public class RTCVideoView extends SurfaceViewRenderer {
    private volatile boolean ckl;
    private VideoSink ckm;
    private Runnable ckn;

    /* loaded from: classes16.dex */
    public interface a extends VideoSink {
    }

    public RTCVideoView(Context context) {
        super(context);
        this.ckl = false;
        this.ckn = null;
        this.ckm = null;
    }

    public RTCVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ckl = false;
        this.ckn = null;
        this.ckm = null;
    }

    public boolean adk() {
        return false;
    }

    public void b(l lVar) {
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void clearImage() {
        if (this.ckm != null) {
            return;
        }
        super.clearImage();
    }

    @Override // org.webrtc.SurfaceViewRenderer, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.ckn != null) {
            this.ckn.run();
            this.ckn = null;
        }
        if (this.ckm != null) {
            if (!this.ckl) {
                this.ckm.onFrame(videoFrame);
                return;
            }
            this.ckm.onFrame(l.a(videoFrame));
        }
        if (adk()) {
            b(l.a(videoFrame));
        } else {
            super.onFrame(videoFrame);
        }
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setEnableHardwareScaler(boolean z) {
        if (this.ckm != null) {
            return;
        }
        super.setEnableHardwareScaler(z);
    }

    public void setExtVideoSink(a aVar) {
        this.ckm = aVar;
    }

    public void setExtVideoSink(VideoSink videoSink, boolean z) {
        this.ckm = videoSink;
        this.ckl = z;
    }

    public void setFirstFrameEventListener(Runnable runnable) {
        this.ckn = runnable;
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setMirror(boolean z) {
        if (this.ckm != null) {
            return;
        }
        super.setMirror(z);
    }
}
