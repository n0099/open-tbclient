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
/* loaded from: classes2.dex */
public class RTCVideoExternalRenderImp extends RTCVideoExternalRender implements RendererCommon.RendererEvents {
    public static final String TAG = "ExternalRenderImp";
    public SurfaceEglRenderer eglRenderer;
    public Boolean hasSurface;
    public SurfaceHolder holder;
    public boolean isGetDimension;
    public RendererCommon.RendererEvents rendererEvents;
    public BaiduRtcRoom.BaiduRtcRoomDelegate roomDelegate;
    public int rotatedFrameHeight;
    public int rotatedFrameWidth;
    public Surface surface;
    public long userId;
    public int videoHeight;
    public int videoRotation;
    public int videoWidth;

    public RTCVideoExternalRenderImp(BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate, long j) {
        super(null, j);
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.videoRotation = 0;
        this.isGetDimension = false;
        this.hasSurface = Boolean.FALSE;
        this.roomDelegate = baiduRtcRoomDelegate;
        this.userId = j;
        this.eglRenderer = new SurfaceEglRenderer(String.valueOf(j));
    }

    public RTCVideoExternalRenderImp(EglBase.Context context, RendererCommon.RendererEvents rendererEvents, long j) {
        super(null, j);
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.videoRotation = 0;
        this.isGetDimension = false;
        this.hasSurface = Boolean.FALSE;
        this.userId = j;
        this.eglRenderer = new SurfaceEglRenderer(String.valueOf(j));
        init(context, rendererEvents);
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public void changeSurfaceSize(int i, int i2) {
        setLayoutAspect(i / i2);
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public void clearImage() {
        this.eglRenderer.clearImage();
    }

    public void disableFpsReduction() {
        this.eglRenderer.disableFpsReduction();
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public Surface getSurface() {
        return this.surface;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public int getVideoRotation() {
        return this.videoRotation;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public boolean hasSurface() {
        return this.hasSurface.booleanValue();
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public void init() {
        Logging.d(TAG, this.userId + " : External renderer init");
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
        RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
        if (rendererEvents != null) {
            rendererEvents.onFirstFrameRendered();
        }
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        Logging.d(TAG, this.userId + " : onFrame time stamp:" + videoFrame.getTimestampNs());
        if (!this.isGetDimension) {
            this.videoWidth = videoFrame.getBuffer().getWidth();
            this.videoHeight = videoFrame.getBuffer().getHeight();
            this.videoRotation = videoFrame.getRotation();
            this.isGetDimension = true;
        }
        this.eglRenderer.onFrame(videoFrame);
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(int i, int i2, int i3) {
        this.videoWidth = i;
        this.videoHeight = i2;
        this.videoRotation = i3;
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.roomDelegate;
        if (baiduRtcRoomDelegate != null) {
            baiduRtcRoomDelegate.onRoomEventUpdate(500, this.userId, null);
        }
        RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
        if (rendererEvents != null) {
            rendererEvents.onFrameResolutionChanged(i, i2, i3);
        }
    }

    public void pauseVideo() {
        this.eglRenderer.pauseVideo();
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public void release() {
        Logging.d(TAG, this.userId + " : External renderer release");
        this.eglRenderer.release();
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public void releaseSurface() {
        this.eglRenderer.surfaceDestroyed(this.holder);
        this.hasSurface = Boolean.FALSE;
        this.surface = null;
        Logging.d(TAG, this.userId + " : External renderer release surface " + this.surface);
    }

    public void setFpsReduction(float f2) {
        this.eglRenderer.setFpsReduction(f2);
    }

    public void setLayoutAspect(float f2) {
        this.eglRenderer.setLayoutAspectRatio(f2);
    }

    public void setMirror(boolean z) {
        this.eglRenderer.setMirror(z);
    }

    public void setRoomDelegate(BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate) {
        this.roomDelegate = baiduRtcRoomDelegate;
    }

    @Override // com.baidu.rtc.RTCVideoExternalRender
    public void setSurface(Surface surface) {
        String str;
        if (surface == null || this.surface == surface) {
            str = this.userId + " : Set remote surface fail! cause surface: " + surface;
        } else {
            if (this.hasSurface.booleanValue() && this.surface != null) {
                releaseSurface();
            }
            this.surface = surface;
            SurfaceHolder surfaceHolder = new SurfaceHolder() { // from class: com.baidu.rtc.RTCVideoExternalRenderImp.1
                @Override // android.view.SurfaceHolder
                public void addCallback(SurfaceHolder.Callback callback) {
                }

                @Override // android.view.SurfaceHolder
                public Surface getSurface() {
                    return RTCVideoExternalRenderImp.this.surface;
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
            this.holder = surfaceHolder;
            this.eglRenderer.surfaceCreated(surfaceHolder);
            this.hasSurface = Boolean.TRUE;
            str = this.userId + " : External renderer set surface =" + this.surface;
        }
        Logging.d(TAG, str);
    }
}
