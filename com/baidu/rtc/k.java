package com.baidu.rtc;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.rtc.BaiduRtcRoom;
import org.webrtc.Logging;
import org.webrtc.RendererCommon;
import org.webrtc.SurfaceEglRenderer;
import org.webrtc.VideoFrame;
/* loaded from: classes9.dex */
public class k extends j implements RendererCommon.RendererEvents {
    private Boolean bXC;
    private SurfaceHolder bXD;
    private boolean bXE;
    private BaiduRtcRoom.a bXF;
    private SurfaceEglRenderer eglRenderer;
    private RendererCommon.RendererEvents rendererEvents;
    private Surface surface;
    private long userId;
    private int videoHeight;
    private int videoRotation;
    private int videoWidth;

    public k(BaiduRtcRoom.a aVar, long j) {
        super(null, j);
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.videoRotation = 0;
        this.bXE = false;
        this.bXC = false;
        this.bXF = aVar;
        this.userId = j;
        this.eglRenderer = new SurfaceEglRenderer(String.valueOf(j));
    }

    @Override // com.baidu.rtc.j
    public void clearImage() {
        this.eglRenderer.clearImage();
    }

    @Override // com.baidu.rtc.j
    public Surface getSurface() {
        return this.surface;
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFirstFrameRendered() {
        if (this.rendererEvents != null) {
            this.rendererEvents.onFirstFrameRendered();
        }
    }

    @Override // com.baidu.rtc.j, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        Logging.d("ExternalRenderImp", this.userId + " : onFrame time stamp:" + videoFrame.getTimestampNs());
        if (!this.bXE) {
            this.videoWidth = videoFrame.getBuffer().getWidth();
            this.videoHeight = videoFrame.getBuffer().getHeight();
            this.videoRotation = videoFrame.getRotation();
            this.bXE = true;
        }
        this.eglRenderer.onFrame(videoFrame);
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(int i, int i2, int i3) {
        this.videoWidth = i;
        this.videoHeight = i2;
        this.videoRotation = i3;
        if (this.bXF != null) {
            this.bXF.onRoomEventUpdate(500, this.userId, null);
        }
        if (this.rendererEvents != null) {
            this.rendererEvents.onFrameResolutionChanged(i, i2, i3);
        }
    }

    @Override // com.baidu.rtc.j
    public void release() {
        Logging.d("ExternalRenderImp", this.userId + " : External renderer release");
        this.eglRenderer.release();
    }

    @Override // com.baidu.rtc.j
    public void releaseSurface() {
        this.eglRenderer.surfaceDestroyed(this.bXD);
        this.bXC = false;
        this.surface = null;
        Logging.d("ExternalRenderImp", this.userId + " : External renderer release surface " + this.surface);
    }
}
