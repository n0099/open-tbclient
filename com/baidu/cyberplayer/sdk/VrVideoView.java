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
import com.baidu.cyberplayer.sdk.b.a;
@Keep
/* loaded from: classes.dex */
public class VrVideoView extends com.baidu.cyberplayer.sdk.b.a {

    /* renamed from: a  reason: collision with root package name */
    public CyberVRRenderProvider f4877a;

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
            cyberVRRenderProvider = d.a(this.f4894b);
            cyberVRRenderProvider.displayMode(i2).interactiveMode(i).projectionMode(i3).asVideo(new CyberVRRenderProvider.IOnSurfaceReadyCallback() { // from class: com.baidu.cyberplayer.sdk.VrVideoView.2
                @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider.IOnSurfaceReadyCallback
                public void onSurfaceReady(Surface surface) {
                    VrVideoView.this.a(1, "surface ready");
                    VrVideoView.this.f4895c = surface;
                    if (VrVideoView.this.f4900h != null) {
                        VrVideoView.this.f4900h.setSurface(surface);
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
        } catch (Exception e2) {
            e2.printStackTrace();
            return cyberVRRenderProvider;
        }
    }

    public void a() {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4877a;
        if (cyberVRRenderProvider == null) {
            CyberLog.e("VrVideoView", "initVRlLib failed, because BDVRRenderDelegate object is null");
            return;
        }
        int i = this.O;
        if (i == 1) {
            cyberVRRenderProvider.init((SurfaceView) this.f4896d);
        } else if (i == 2) {
            cyberVRRenderProvider.init((TextureView) this.f4896d);
        } else {
            a(4, "GLView invalid type");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    public void a(int i, int i2, int i3, int i4) {
        if (this.f4877a == null) {
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
        this.f4877a.onTextureResize(i, i2);
        a(1, String.format("onTextureResize,w=%d,h=%d", Integer.valueOf(i), Integer.valueOf(i2)));
        this.Q = i;
        this.R = i2;
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    public boolean a(int i) {
        if (super.a(i)) {
            return true;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        if (i == 1) {
            View gLSurfaceView = new GLSurfaceView(getContext());
            this.f4896d = gLSurfaceView;
            addView(gLSurfaceView, 0, layoutParams);
            return true;
        }
        return false;
    }

    public boolean a(int i, int i2, int i3, int i4, int i5) {
        a(1, String.format("playerType:" + i + " interactiveMode:" + i2 + " displayMode:" + i3 + " projectionMode:" + i4 + " viewType:" + i5, new Object[0]));
        this.f4898f = false;
        this.i = i;
        this.L = i2;
        this.M = i3;
        this.N = i4;
        this.O = i5;
        CyberVRRenderProvider a2 = a(i2, i3, i4);
        this.f4877a = a2;
        if (a2 == null) {
            CyberLog.e("VrVideoView", "initVR failed. Please check the log.");
            return false;
        }
        b(i5);
        a();
        return b(this.f4894b);
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    public boolean b() {
        return this.f4898f || this.f4877a != null;
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    public void destroyRender() {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4877a;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.onDestroy();
            this.f4877a = null;
            this.S = a.i.PAUSED;
        }
    }

    public int getSourceType() {
        return this.P;
    }

    public boolean initVR() {
        if (this.i == 0) {
            this.i = 1;
        }
        if (this.L == 0) {
            this.L = 5;
        }
        if (this.M == 0) {
            this.M = 101;
        }
        if (this.N == 0) {
            this.N = 201;
        }
        if (this.O == 0) {
            this.O = 1;
        }
        a(1, String.format("playerType:" + this.i + " interactiveMode:" + this.L + " displayMode:" + this.M + " sourceType:" + this.P + " viewType:" + this.O, new Object[0]));
        return a(this.i, this.L, this.M, this.N, this.O);
    }

    public void onOrientationChanged() {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4877a;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.onOrientationChanged();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    public void pauseRender() {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4877a;
        if (cyberVRRenderProvider == null || this.S != a.i.RESUMED) {
            return;
        }
        cyberVRRenderProvider.onPause();
        this.S = a.i.PAUSED;
    }

    public void pinchEnabled(boolean z) {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4877a;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.pinchEnabled(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    public void resumeRender() {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4877a;
        if (cyberVRRenderProvider == null || this.S != a.i.PAUSED) {
            return;
        }
        cyberVRRenderProvider.onResume();
        this.S = a.i.RESUMED;
    }

    public void setDisplayMode(int i) {
        this.M = i;
        switchDisplayMode(i);
    }

    public void setFov(float f2, float f3, float f4) {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4877a;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.setFov(f2, f3, f4);
        }
    }

    public void setInteractiveMode(int i) {
        this.L = i;
        switchInteractiveMode(i);
    }

    public void setProjectionMode(int i) {
        this.N = i;
        switchProjectionMode(i);
    }

    public void setSourceType(int i) {
        this.P = i;
    }

    public void switchDisplayMode(int i) {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4877a;
        if (cyberVRRenderProvider != null) {
            this.M = i;
            cyberVRRenderProvider.switchDisplayMode(i);
        }
    }

    public void switchInteractiveMode(int i) {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4877a;
        if (cyberVRRenderProvider != null) {
            this.L = i;
            cyberVRRenderProvider.switchInteractiveMode(i);
        }
    }

    public void switchProjectionMode(int i) {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4877a;
        if (cyberVRRenderProvider != null) {
            this.N = i;
            cyberVRRenderProvider.switchProjectionMode(i);
        }
    }
}
