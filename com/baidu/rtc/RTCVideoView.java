package com.baidu.rtc;

import android.content.Context;
import android.util.AttributeSet;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes10.dex */
public class RTCVideoView extends SurfaceViewRenderer {
    private volatile boolean cyd;
    private VideoSink cye;
    private Runnable cyf;

    /* loaded from: classes10.dex */
    public interface a extends VideoSink {
    }

    public RTCVideoView(Context context) {
        super(context);
        this.cyd = false;
        this.cyf = null;
        this.cye = null;
    }

    public RTCVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyd = false;
        this.cyf = null;
        this.cye = null;
    }

    public boolean aip() {
        return false;
    }

    public void b(l lVar) {
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void clearImage() {
        if (this.cye != null) {
            return;
        }
        super.clearImage();
    }

    @Override // org.webrtc.SurfaceViewRenderer, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.cyf != null) {
            this.cyf.run();
            this.cyf = null;
        }
        if (this.cye != null) {
            if (!this.cyd) {
                this.cye.onFrame(videoFrame);
                return;
            }
            this.cye.onFrame(l.a(videoFrame));
        }
        if (aip()) {
            b(l.a(videoFrame));
        } else {
            super.onFrame(videoFrame);
        }
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setEnableHardwareScaler(boolean z) {
        if (this.cye != null) {
            return;
        }
        super.setEnableHardwareScaler(z);
    }

    public void setExtVideoSink(a aVar) {
        this.cye = aVar;
    }

    public void setExtVideoSink(VideoSink videoSink, boolean z) {
        this.cye = videoSink;
        this.cyd = z;
    }

    public void setFirstFrameEventListener(Runnable runnable) {
        this.cyf = runnable;
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setMirror(boolean z) {
        if (this.cye != null) {
            return;
        }
        super.setMirror(z);
    }
}
