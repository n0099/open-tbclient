package com.baidu.rtc;

import android.content.Context;
import android.util.AttributeSet;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes9.dex */
public class RTCVideoView extends SurfaceViewRenderer {
    private volatile boolean clV;
    private VideoSink clW;
    private Runnable clX;

    /* loaded from: classes9.dex */
    public interface a extends VideoSink {
    }

    public RTCVideoView(Context context) {
        super(context);
        this.clV = false;
        this.clX = null;
        this.clW = null;
    }

    public RTCVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clV = false;
        this.clX = null;
        this.clW = null;
    }

    public boolean adS() {
        return false;
    }

    public void b(l lVar) {
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void clearImage() {
        if (this.clW != null) {
            return;
        }
        super.clearImage();
    }

    @Override // org.webrtc.SurfaceViewRenderer, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.clX != null) {
            this.clX.run();
            this.clX = null;
        }
        if (this.clW != null) {
            if (!this.clV) {
                this.clW.onFrame(videoFrame);
                return;
            }
            this.clW.onFrame(l.a(videoFrame));
        }
        if (adS()) {
            b(l.a(videoFrame));
        } else {
            super.onFrame(videoFrame);
        }
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setEnableHardwareScaler(boolean z) {
        if (this.clW != null) {
            return;
        }
        super.setEnableHardwareScaler(z);
    }

    public void setExtVideoSink(a aVar) {
        this.clW = aVar;
    }

    public void setExtVideoSink(VideoSink videoSink, boolean z) {
        this.clW = videoSink;
        this.clV = z;
    }

    public void setFirstFrameEventListener(Runnable runnable) {
        this.clX = runnable;
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setMirror(boolean z) {
        if (this.clW != null) {
            return;
        }
        super.setMirror(z);
    }
}
