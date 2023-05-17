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
    public CyberVRRenderProvider a;

    public VrVideoView(Context context) {
        super(context);
        initVR();
    }

    public VrVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initVR();
    }

    public VrVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
        initVR();
    }

    private boolean b(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    public CyberVRRenderProvider a(int i, int i2, int i3) {
        CyberVRRenderProvider cyberVRRenderProvider = null;
        try {
            cyberVRRenderProvider = d.a(this.b);
            cyberVRRenderProvider.displayMode(i2).interactiveMode(i).projectionMode(i3).asVideo(new CyberVRRenderProvider.IOnSurfaceReadyCallback() { // from class: com.baidu.cyberplayer.sdk.VrVideoView.2
                @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider.IOnSurfaceReadyCallback
                public void onSurfaceReady(Surface surface) {
                    VrVideoView.this.a(1, "surface ready");
                    VrVideoView.this.c = surface;
                    if (VrVideoView.this.h != null) {
                        VrVideoView.this.h.setSurface(surface);
                    } else {
                        VrVideoView.this.e();
                    }
                    VrVideoView.this.onOrientationChanged();
                    if (VrVideoView.this.A != null) {
                        VrVideoView.this.A.a();
                    }
                }
            }).ifNotSupport(new CyberVRRenderProvider.INotSupportCallback() { // from class: com.baidu.cyberplayer.sdk.VrVideoView.1
                @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider.INotSupportCallback
                public void onNotSupport(int i4) {
                    if (VrVideoView.this.w != null) {
                        VrVideoView.this.w.onInfo(1, i4, null);
                    }
                }
            }).pinchEnabled(false);
            return cyberVRRenderProvider;
        } catch (Exception e) {
            e.printStackTrace();
            return cyberVRRenderProvider;
        }
    }

    public void a() {
        CyberVRRenderProvider cyberVRRenderProvider = this.a;
        if (cyberVRRenderProvider == null) {
            CyberLog.e("VrVideoView", "initVRlLib failed, because BDVRRenderDelegate object is null");
            return;
        }
        int i = this.P;
        if (i == 1) {
            cyberVRRenderProvider.init((SurfaceView) this.d);
        } else if (i == 2) {
            cyberVRRenderProvider.init((TextureView) this.d);
        } else {
            a(4, "GLView invalid type");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void a(int i, int i2, int i3, int i4) {
        if (this.a == null) {
            super.a(i, i2, i3, i4);
            return;
        }
        if (i4 > 0 && i3 > 0) {
            if (i3 > i4) {
                i = (i * i3) / i4;
            } else {
                i2 = (i2 * i4) / i3;
            }
        }
        this.a.onTextureResize(i, i2);
        a(1, String.format("onTextureResize,w=%d,h=%d", Integer.valueOf(i), Integer.valueOf(i2)));
        this.R = i;
        this.S = i2;
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public boolean a(int i) {
        if (super.a(i)) {
            return true;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        if (i == 1) {
            View gLSurfaceView = new GLSurfaceView(getContext());
            this.d = gLSurfaceView;
            addView(gLSurfaceView, 0, layoutParams);
            return true;
        }
        return false;
    }

    public boolean a(int i, int i2, int i3, int i4, int i5) {
        a(1, String.format("playerType:" + i + " interactiveMode:" + i2 + " displayMode:" + i3 + " projectionMode:" + i4 + " viewType:" + i5, new Object[0]));
        this.f = false;
        this.i = i;
        this.M = i2;
        this.N = i3;
        this.O = i4;
        this.P = i5;
        CyberVRRenderProvider a = a(i2, i3, i4);
        this.a = a;
        if (a == null) {
            CyberLog.e("VrVideoView", "initVR failed. Please check the log.");
            return false;
        }
        b(i5);
        a();
        return b(this.b);
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public boolean b() {
        return this.f || this.a != null;
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void destroyRender() {
        CyberVRRenderProvider cyberVRRenderProvider = this.a;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.onDestroy();
            this.a = null;
            this.T = MovieView.i.PAUSED;
        }
    }

    public int getSourceType() {
        return this.Q;
    }

    public boolean initVR() {
        if (this.i == 0) {
            this.i = 1;
        }
        if (this.M == 0) {
            this.M = 5;
        }
        if (this.N == 0) {
            this.N = 101;
        }
        if (this.O == 0) {
            this.O = 201;
        }
        if (this.P == 0) {
            this.P = 1;
        }
        a(1, String.format("playerType:" + this.i + " interactiveMode:" + this.M + " displayMode:" + this.N + " sourceType:" + this.Q + " viewType:" + this.P, new Object[0]));
        return a(this.i, this.M, this.N, this.O, this.P);
    }

    public void onOrientationChanged() {
        CyberVRRenderProvider cyberVRRenderProvider = this.a;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.onOrientationChanged();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void pauseRender() {
        CyberVRRenderProvider cyberVRRenderProvider = this.a;
        if (cyberVRRenderProvider == null || this.T != MovieView.i.RESUMED) {
            return;
        }
        cyberVRRenderProvider.onPause();
        this.T = MovieView.i.PAUSED;
    }

    public void pinchEnabled(boolean z) {
        CyberVRRenderProvider cyberVRRenderProvider = this.a;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.pinchEnabled(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.vrplayer.MovieView
    public void resumeRender() {
        CyberVRRenderProvider cyberVRRenderProvider = this.a;
        if (cyberVRRenderProvider == null || this.T != MovieView.i.PAUSED) {
            return;
        }
        cyberVRRenderProvider.onResume();
        this.T = MovieView.i.RESUMED;
    }

    public void setDisplayMode(int i) {
        this.N = i;
        switchDisplayMode(i);
    }

    public void setFov(float f, float f2, float f3) {
        CyberVRRenderProvider cyberVRRenderProvider = this.a;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.setFov(f, f2, f3);
        }
    }

    public void setInteractiveMode(int i) {
        this.M = i;
        switchInteractiveMode(i);
    }

    public void setProjectionMode(int i) {
        this.O = i;
        switchProjectionMode(i);
    }

    public void setSourceType(int i) {
        this.Q = i;
    }

    public void switchDisplayMode(int i) {
        CyberVRRenderProvider cyberVRRenderProvider = this.a;
        if (cyberVRRenderProvider != null) {
            this.N = i;
            cyberVRRenderProvider.switchDisplayMode(i);
        }
    }

    public void switchInteractiveMode(int i) {
        CyberVRRenderProvider cyberVRRenderProvider = this.a;
        if (cyberVRRenderProvider != null) {
            this.M = i;
            cyberVRRenderProvider.switchInteractiveMode(i);
        }
    }

    public void switchProjectionMode(int i) {
        CyberVRRenderProvider cyberVRRenderProvider = this.a;
        if (cyberVRRenderProvider != null) {
            this.O = i;
            cyberVRRenderProvider.switchProjectionMode(i);
        }
    }
}
