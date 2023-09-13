package com.baidu.cyberplayer.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.cyberplayer.sdk.CyberVRRenderProvider;
import com.baidu.cyberplayer.sdk.vrplayer.MovieView;
@Keep
/* loaded from: classes3.dex */
public class VrVideoView extends MovieView {
    public static final String TAG = "VrVideoView";
    public CyberVRRenderProvider mCyberVRRenderProvider;

    public VrVideoView(Context context) {
        super(context);
        initVR();
    }

    private boolean supportsEs2(Context context) {
        if (((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 131072) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public boolean createView(int i) {
        if (super.createView(i)) {
            return true;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        if (i == 1) {
            View gLSurfaceView = new GLSurfaceView(getContext());
            this.renderView = gLSurfaceView;
            addView(gLSurfaceView, 0, layoutParams);
            return true;
        }
        if (i == 2) {
        }
        return false;
    }

    public void pinchEnabled(boolean z) {
        CyberVRRenderProvider cyberVRRenderProvider = this.mCyberVRRenderProvider;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.pinchEnabled(z);
        }
    }

    public void setDisplayMode(int i) {
        this.displayMode = i;
        switchDisplayMode(i);
    }

    public void setInteractiveMode(int i) {
        this.interactiveMode = i;
        switchInteractiveMode(i);
    }

    public void setProjectionMode(int i) {
        this.projectionMode = i;
        switchProjectionMode(i);
    }

    public void setSourceType(int i) {
        this.sourceType = i;
    }

    public void switchDisplayMode(int i) {
        CyberVRRenderProvider cyberVRRenderProvider = this.mCyberVRRenderProvider;
        if (cyberVRRenderProvider != null) {
            this.displayMode = i;
            cyberVRRenderProvider.switchDisplayMode(i);
        }
    }

    public void switchInteractiveMode(int i) {
        CyberVRRenderProvider cyberVRRenderProvider = this.mCyberVRRenderProvider;
        if (cyberVRRenderProvider != null) {
            this.interactiveMode = i;
            cyberVRRenderProvider.switchInteractiveMode(i);
        }
    }

    public void switchProjectionMode(int i) {
        CyberVRRenderProvider cyberVRRenderProvider = this.mCyberVRRenderProvider;
        if (cyberVRRenderProvider != null) {
            this.projectionMode = i;
            cyberVRRenderProvider.switchProjectionMode(i);
        }
    }

    public VrVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initVR();
    }

    public VrVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        checkContext(context);
        initVR();
    }

    public CyberVRRenderProvider createVRLib(int i, int i2, int i3) {
        CyberVRRenderProvider cyberVRRenderProvider = null;
        try {
            cyberVRRenderProvider = CyberPlayerCoreInvoker.createCyberVRRender(this.appContext);
            cyberVRRenderProvider.displayMode(i2).interactiveMode(i).projectionMode(i3).asVideo(new CyberVRRenderProvider.IOnSurfaceReadyCallback() { // from class: com.baidu.cyberplayer.sdk.VrVideoView.2
                @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider.IOnSurfaceReadyCallback
                public void onSurfaceReady(Surface surface) {
                    VrVideoView.this.printCommonLog(1, "surface ready");
                    VrVideoView.this.surface = surface;
                    if (VrVideoView.this.mediaPlayer == null) {
                        VrVideoView.this.openVideo();
                    } else {
                        VrVideoView.this.mediaPlayer.setSurface(surface);
                    }
                    VrVideoView.this.onOrientationChanged();
                    if (VrVideoView.this.onSurfaceReadyListener != null) {
                        VrVideoView.this.onSurfaceReadyListener.onSurfaceReady();
                    }
                }
            }).ifNotSupport(new CyberVRRenderProvider.INotSupportCallback() { // from class: com.baidu.cyberplayer.sdk.VrVideoView.1
                @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider.INotSupportCallback
                public void onNotSupport(int i4) {
                    if (VrVideoView.this.onInfoListener != null) {
                        VrVideoView.this.onInfoListener.onInfo(1, i4, null);
                    }
                }
            }).pinchEnabled(false);
            return cyberVRRenderProvider;
        } catch (Exception e) {
            e.printStackTrace();
            return cyberVRRenderProvider;
        }
    }

    public void setFov(float f, float f2, float f3) {
        CyberVRRenderProvider cyberVRRenderProvider = this.mCyberVRRenderProvider;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.setFov(f, f2, f3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void destroyRender() {
        CyberVRRenderProvider cyberVRRenderProvider = this.mCyberVRRenderProvider;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.onDestroy();
            this.mCyberVRRenderProvider = null;
            this.curRenderState = MovieView.RenderState.PAUSED;
        }
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public void initVRLib() {
        CyberVRRenderProvider cyberVRRenderProvider = this.mCyberVRRenderProvider;
        if (cyberVRRenderProvider == null) {
            CyberLog.e(TAG, "initVRlLib failed, because BDVRRenderDelegate object is null");
            return;
        }
        int i = this.viewType;
        if (i == 1) {
            cyberVRRenderProvider.init((SurfaceView) this.renderView);
        } else if (i == 2) {
            cyberVRRenderProvider.init((TextureView) this.renderView);
        } else {
            printCommonLog(4, "GLView invalid type");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public boolean is23DReady() {
        if (!this.b2DVideo && this.mCyberVRRenderProvider == null) {
            return false;
        }
        return true;
    }

    public void onOrientationChanged() {
        CyberVRRenderProvider cyberVRRenderProvider = this.mCyberVRRenderProvider;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.onOrientationChanged();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void pauseRender() {
        CyberVRRenderProvider cyberVRRenderProvider = this.mCyberVRRenderProvider;
        if (cyberVRRenderProvider != null && this.curRenderState == MovieView.RenderState.RESUMED) {
            cyberVRRenderProvider.onPause();
            this.curRenderState = MovieView.RenderState.PAUSED;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void resumeRender() {
        CyberVRRenderProvider cyberVRRenderProvider = this.mCyberVRRenderProvider;
        if (cyberVRRenderProvider != null && this.curRenderState == MovieView.RenderState.PAUSED) {
            cyberVRRenderProvider.onResume();
            this.curRenderState = MovieView.RenderState.RESUMED;
        }
    }

    public boolean initVR() {
        if (this.playerType == 0) {
            this.playerType = 1;
        }
        if (this.interactiveMode == 0) {
            this.interactiveMode = 5;
        }
        if (this.displayMode == 0) {
            this.displayMode = 101;
        }
        if (this.projectionMode == 0) {
            this.projectionMode = 201;
        }
        if (this.viewType == 0) {
            this.viewType = 1;
        }
        printCommonLog(1, String.format("playerType:" + this.playerType + " interactiveMode:" + this.interactiveMode + " displayMode:" + this.displayMode + " sourceType:" + this.sourceType + " viewType:" + this.viewType, new Object[0]));
        return initVRInternal(this.playerType, this.interactiveMode, this.displayMode, this.projectionMode, this.viewType);
    }

    public boolean initVRInternal(int i, int i2, int i3, int i4, int i5) {
        printCommonLog(1, String.format("playerType:" + i + " interactiveMode:" + i2 + " displayMode:" + i3 + " projectionMode:" + i4 + " viewType:" + i5, new Object[0]));
        this.b2DVideo = false;
        this.playerType = i;
        this.interactiveMode = i2;
        this.displayMode = i3;
        this.projectionMode = i4;
        this.viewType = i5;
        CyberVRRenderProvider createVRLib = createVRLib(i2, i3, i4);
        this.mCyberVRRenderProvider = createVRLib;
        if (createVRLib == null) {
            CyberLog.e(TAG, "initVR failed. Please check the log.");
            return false;
        }
        initView(i5);
        initVRLib();
        return supportsEs2(this.appContext);
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void on23DVideoSizeChange(int i, int i2, int i3, int i4) {
        if (this.mCyberVRRenderProvider != null) {
            if (i4 > 0 && i3 > 0) {
                if (i3 > i4) {
                    i = (i * i3) / i4;
                } else {
                    i2 = (i2 * i4) / i3;
                }
            }
            this.mCyberVRRenderProvider.onTextureResize(i, i2);
            printCommonLog(1, String.format("onTextureResize,w=%d,h=%d", Integer.valueOf(i), Integer.valueOf(i2)));
            this.srcWidth = i;
            this.srcHeight = i2;
            return;
        }
        super.on23DVideoSizeChange(i, i2, i3, i4);
    }
}
