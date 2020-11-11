package com.baidu.rtc;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.rtc.BaiduRtcRoom;
import org.webrtc.EglBase;
import org.webrtc.EglBase_CC;
import org.webrtc.GlRectDrawer;
import org.webrtc.Logging;
import org.webrtc.RendererCommon;
import org.webrtc.SurfaceEglRenderer;
import org.webrtc.ThreadUtils;
import org.webrtc.VideoFrame;
/* loaded from: classes9.dex */
public class k extends j implements RendererCommon.RendererEvents {
    private Boolean clQ;
    private SurfaceHolder clR;
    private boolean clS;
    private BaiduRtcRoom.a clT;
    private SurfaceEglRenderer eglRenderer;
    private RendererCommon.RendererEvents rendererEvents;
    private int rotatedFrameHeight;
    private int rotatedFrameWidth;
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
        this.clS = false;
        this.clQ = false;
        this.clT = aVar;
        this.userId = j;
        this.eglRenderer = new SurfaceEglRenderer(String.valueOf(j));
    }

    public void G(float f) {
        this.eglRenderer.setLayoutAspectRatio(f);
    }

    @Override // com.baidu.rtc.j
    public void changeSurfaceSize(int i, int i2) {
        G(i / i2);
    }

    @Override // com.baidu.rtc.j
    public void clearImage() {
        this.eglRenderer.clearImage();
    }

    @Override // com.baidu.rtc.j
    public Surface getSurface() {
        return this.surface;
    }

    @Override // com.baidu.rtc.j
    public boolean hasSurface() {
        return this.clQ.booleanValue();
    }

    @Override // com.baidu.rtc.j
    public void init() {
        Logging.d("ExternalRenderImp", this.userId + " : External renderer init");
        init(EglBase_CC.create().getEglBaseContext(), null);
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents) {
        init(context, rendererEvents, EglBase.CONFIG_PLAIN, new GlRectDrawer());
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        ThreadUtils.checkIsOnMainThread();
        this.rendererEvents = rendererEvents;
        this.rotatedFrameWidth = 0;
        this.rotatedFrameHeight = 0;
        this.eglRenderer.init(context, this, iArr, glDrawer);
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
        if (!this.clS) {
            this.videoWidth = videoFrame.getBuffer().getWidth();
            this.videoHeight = videoFrame.getBuffer().getHeight();
            this.videoRotation = videoFrame.getRotation();
            this.clS = true;
        }
        this.eglRenderer.onFrame(videoFrame);
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(int i, int i2, int i3) {
        this.videoWidth = i;
        this.videoHeight = i2;
        this.videoRotation = i3;
        if (this.clT != null) {
            this.clT.onRoomEventUpdate(500, this.userId, null);
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
        this.eglRenderer.surfaceDestroyed(this.clR);
        this.clQ = false;
        this.surface = null;
        Logging.d("ExternalRenderImp", this.userId + " : External renderer release surface " + this.surface);
    }

    @Override // com.baidu.rtc.j
    public void setSurface(Surface surface) {
        if (surface == null || this.surface == surface) {
            Logging.d("ExternalRenderImp", this.userId + " : Set remote surface fail! cause surface: " + surface);
            return;
        }
        if (this.clQ.booleanValue() && this.surface != null) {
            releaseSurface();
        }
        this.surface = surface;
        this.clR = new SurfaceHolder() { // from class: com.baidu.rtc.k.1
            @Override // android.view.SurfaceHolder
            public void addCallback(SurfaceHolder.Callback callback) {
            }

            @Override // android.view.SurfaceHolder
            public Surface getSurface() {
                return k.this.surface;
            }

            @Override // android.view.SurfaceHolder
            public Rect getSurfaceFrame() {
                return null;
            }

            @Override // android.view.SurfaceHolder
            public boolean isCreating() {
                return true;
            }

            @Override // android.view.SurfaceHolder
            public Canvas lockCanvas() {
                return null;
            }

            @Override // android.view.SurfaceHolder
            public Canvas lockCanvas(Rect rect) {
                return null;
            }

            @Override // android.view.SurfaceHolder
            public void removeCallback(SurfaceHolder.Callback callback) {
            }

            @Override // android.view.SurfaceHolder
            public void setFixedSize(int i, int i2) {
            }

            @Override // android.view.SurfaceHolder
            public void setFormat(int i) {
            }

            @Override // android.view.SurfaceHolder
            public void setKeepScreenOn(boolean z) {
            }

            @Override // android.view.SurfaceHolder
            public void setSizeFromLayout() {
            }

            @Override // android.view.SurfaceHolder
            public void setType(int i) {
            }

            @Override // android.view.SurfaceHolder
            public void unlockCanvasAndPost(Canvas canvas) {
            }
        };
        this.eglRenderer.surfaceCreated(this.clR);
        this.clQ = true;
        Logging.d("ExternalRenderImp", this.userId + " : External renderer set surface =" + this.surface);
    }
}
