package com.baidu.rtc;

import android.content.Context;
import android.util.AttributeSet;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes9.dex */
public class RTCVideoView extends SurfaceViewRenderer {
    private volatile boolean bXG;
    private VideoSink bXH;
    private Runnable bXI;

    /* loaded from: classes9.dex */
    public interface a extends VideoSink {
    }

    public RTCVideoView(Context context) {
        super(context);
        this.bXG = false;
        this.bXI = null;
        this.bXH = null;
    }

    public RTCVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bXG = false;
        this.bXI = null;
        this.bXH = null;
    }

    public boolean Zz() {
        return false;
    }

    public void b(l lVar) {
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void clearImage() {
        if (this.bXH != null) {
            return;
        }
        super.clearImage();
    }

    @Override // org.webrtc.SurfaceViewRenderer, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.bXI != null) {
            this.bXI.run();
            this.bXI = null;
        }
        if (this.bXH != null) {
            if (!this.bXG) {
                this.bXH.onFrame(videoFrame);
                return;
            }
            this.bXH.onFrame(l.a(videoFrame));
        }
        if (Zz()) {
            b(l.a(videoFrame));
        } else {
            super.onFrame(videoFrame);
        }
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setEnableHardwareScaler(boolean z) {
        if (this.bXH != null) {
            return;
        }
        super.setEnableHardwareScaler(z);
    }

    public void setExtVideoSink(a aVar) {
        this.bXH = aVar;
    }

    public void setExtVideoSink(VideoSink videoSink, boolean z) {
        this.bXH = videoSink;
        this.bXG = z;
    }

    public void setFirstFrameEventListener(Runnable runnable) {
        this.bXI = runnable;
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setMirror(boolean z) {
        if (this.bXH != null) {
            return;
        }
        super.setMirror(z);
    }
}
