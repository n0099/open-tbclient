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
/* loaded from: classes2.dex */
public class VrVideoView extends com.baidu.cyberplayer.sdk.b.a {

    /* renamed from: a  reason: collision with root package name */
    public CyberVRRenderProvider f4851a;

    public VrVideoView(Context context) {
        super(context);
        initVR();
    }

    public VrVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initVR();
    }

    public VrVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
        initVR();
    }

    private boolean b(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    public CyberVRRenderProvider a(int i2, int i3, int i4) {
        CyberVRRenderProvider cyberVRRenderProvider = null;
        try {
            cyberVRRenderProvider = d.a(this.f4868b);
            cyberVRRenderProvider.displayMode(i3).interactiveMode(i2).projectionMode(i4).asVideo(new CyberVRRenderProvider.IOnSurfaceReadyCallback() { // from class: com.baidu.cyberplayer.sdk.VrVideoView.2
                @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider.IOnSurfaceReadyCallback
                public void onSurfaceReady(Surface surface) {
                    VrVideoView.this.a(1, "surface ready");
                    VrVideoView.this.f4869c = surface;
                    if (VrVideoView.this.f4874h != null) {
                        VrVideoView.this.f4874h.setSurface(surface);
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
                public void onNotSupport(int i5) {
                    if (VrVideoView.this.w != null) {
                        VrVideoView.this.w.onInfo(1, i5, null);
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
        CyberVRRenderProvider cyberVRRenderProvider = this.f4851a;
        if (cyberVRRenderProvider == null) {
            CyberLog.e("VrVideoView", "initVRlLib failed, because BDVRRenderDelegate object is null");
            return;
        }
        int i2 = this.O;
        if (i2 == 1) {
            cyberVRRenderProvider.init((SurfaceView) this.f4870d);
        } else if (i2 == 2) {
            cyberVRRenderProvider.init((TextureView) this.f4870d);
        } else {
            a(4, "GLView invalid type");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    public void a(int i2, int i3, int i4, int i5) {
        if (this.f4851a == null) {
            super.a(i2, i3, i4, i5);
            return;
        }
        if (i5 > 0 && i4 > 0) {
            if (i4 > i5) {
                i2 = (i2 * i4) / i5;
            } else {
                i3 = (i3 * i5) / i4;
            }
        }
        this.f4851a.onTextureResize(i2, i3);
        a(1, String.format("onTextureResize,w=%d,h=%d", Integer.valueOf(i2), Integer.valueOf(i3)));
        this.Q = i2;
        this.R = i3;
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    public boolean a(int i2) {
        if (super.a(i2)) {
            return true;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        if (i2 == 1) {
            View gLSurfaceView = new GLSurfaceView(getContext());
            this.f4870d = gLSurfaceView;
            addView(gLSurfaceView, 0, layoutParams);
            return true;
        }
        return false;
    }

    public boolean a(int i2, int i3, int i4, int i5, int i6) {
        a(1, String.format("playerType:" + i2 + " interactiveMode:" + i3 + " displayMode:" + i4 + " projectionMode:" + i5 + " viewType:" + i6, new Object[0]));
        this.f4872f = false;
        this.f4875i = i2;
        this.L = i3;
        this.M = i4;
        this.N = i5;
        this.O = i6;
        CyberVRRenderProvider a2 = a(i3, i4, i5);
        this.f4851a = a2;
        if (a2 == null) {
            CyberLog.e("VrVideoView", "initVR failed. Please check the log.");
            return false;
        }
        b(i6);
        a();
        return b(this.f4868b);
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    public boolean b() {
        return this.f4872f || this.f4851a != null;
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    public void destroyRender() {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4851a;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.onDestroy();
            this.f4851a = null;
            this.S = a.i.PAUSED;
        }
    }

    public int getSourceType() {
        return this.P;
    }

    public boolean initVR() {
        if (this.f4875i == 0) {
            this.f4875i = 1;
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
        a(1, String.format("playerType:" + this.f4875i + " interactiveMode:" + this.L + " displayMode:" + this.M + " sourceType:" + this.P + " viewType:" + this.O, new Object[0]));
        return a(this.f4875i, this.L, this.M, this.N, this.O);
    }

    public void onOrientationChanged() {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4851a;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.onOrientationChanged();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    public void pauseRender() {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4851a;
        if (cyberVRRenderProvider == null || this.S != a.i.RESUMED) {
            return;
        }
        cyberVRRenderProvider.onPause();
        this.S = a.i.PAUSED;
    }

    public void pinchEnabled(boolean z) {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4851a;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.pinchEnabled(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    public void resumeRender() {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4851a;
        if (cyberVRRenderProvider == null || this.S != a.i.PAUSED) {
            return;
        }
        cyberVRRenderProvider.onResume();
        this.S = a.i.RESUMED;
    }

    public void setDisplayMode(int i2) {
        this.M = i2;
        switchDisplayMode(i2);
    }

    public void setFov(float f2, float f3, float f4) {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4851a;
        if (cyberVRRenderProvider != null) {
            cyberVRRenderProvider.setFov(f2, f3, f4);
        }
    }

    public void setInteractiveMode(int i2) {
        this.L = i2;
        switchInteractiveMode(i2);
    }

    public void setProjectionMode(int i2) {
        this.N = i2;
        switchProjectionMode(i2);
    }

    public void setSourceType(int i2) {
        this.P = i2;
    }

    public void switchDisplayMode(int i2) {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4851a;
        if (cyberVRRenderProvider != null) {
            this.M = i2;
            cyberVRRenderProvider.switchDisplayMode(i2);
        }
    }

    public void switchInteractiveMode(int i2) {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4851a;
        if (cyberVRRenderProvider != null) {
            this.L = i2;
            cyberVRRenderProvider.switchInteractiveMode(i2);
        }
    }

    public void switchProjectionMode(int i2) {
        CyberVRRenderProvider cyberVRRenderProvider = this.f4851a;
        if (cyberVRRenderProvider != null) {
            this.N = i2;
            cyberVRRenderProvider.switchProjectionMode(i2);
        }
    }
}
