package com.baidu.cyberplayer.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.baidu.cyberplayer.sdk.CyberVRRenderProvider;
import com.baidu.cyberplayer.sdk.b.a;
import com.meizu.cloud.pushsdk.constants.PushConstants;
@Keep
/* loaded from: classes5.dex */
public class VrVideoView extends com.baidu.cyberplayer.sdk.b.a {

    /* renamed from: a  reason: collision with root package name */
    protected CyberVRRenderProvider f1720a;

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
        return ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    protected CyberVRRenderProvider a(int i, int i2, int i3) {
        CyberVRRenderProvider cyberVRRenderProvider = null;
        try {
            cyberVRRenderProvider = d.a(this.f1733b);
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

    protected void a() {
        if (this.f1720a == null) {
            CyberLog.e("VrVideoView", "initVRlLib failed, because BDVRRenderDelegate object is null");
        } else if (this.O == 1) {
            this.f1720a.init((SurfaceView) this.d);
        } else if (this.O == 2) {
            this.f1720a.init((TextureView) this.d);
        } else {
            a(4, "GLView invalid type");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cyberplayer.sdk.b.a
    public void a(int i, int i2, int i3, int i4) {
        if (this.f1720a == null) {
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
        this.f1720a.onTextureResize(i, i2);
        a(1, String.format("onTextureResize,w=%d,h=%d", Integer.valueOf(i), Integer.valueOf(i2)));
        this.Q = i;
        this.R = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cyberplayer.sdk.b.a
    public boolean a(int i) {
        if (super.a(i)) {
            return true;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        if (i != 1) {
            return i == 2 ? false : false;
        }
        this.d = new GLSurfaceView(getContext());
        addView(this.d, 0, layoutParams);
        return true;
    }

    protected boolean a(int i, int i2, int i3, int i4, int i5) {
        a(1, String.format("playerType:" + i + " interactiveMode:" + i2 + " displayMode:" + i3 + " projectionMode:" + i4 + " viewType:" + i5, new Object[0]));
        this.f = false;
        this.i = i;
        this.L = i2;
        this.M = i3;
        this.N = i4;
        this.O = i5;
        this.f1720a = a(i2, i3, i4);
        if (this.f1720a == null) {
            CyberLog.e("VrVideoView", "initVR failed. Please check the log.");
            return false;
        }
        b(i5);
        a();
        return b(this.f1733b);
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    protected boolean b() {
        return this.f || this.f1720a != null;
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    public void destroyRender() {
        if (this.f1720a != null) {
            this.f1720a.onDestroy();
            this.f1720a = null;
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
        if (this.f1720a != null) {
            this.f1720a.onOrientationChanged();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    public void pauseRender() {
        if (this.f1720a == null || this.S != a.i.RESUMED) {
            return;
        }
        this.f1720a.onPause();
        this.S = a.i.PAUSED;
    }

    public void pinchEnabled(boolean z) {
        if (this.f1720a != null) {
            this.f1720a.pinchEnabled(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.b.a
    public void resumeRender() {
        if (this.f1720a == null || this.S != a.i.PAUSED) {
            return;
        }
        this.f1720a.onResume();
        this.S = a.i.RESUMED;
    }

    public void setDisplayMode(int i) {
        this.M = i;
        switchDisplayMode(i);
    }

    public void setFov(float f, float f2, float f3) {
        if (this.f1720a != null) {
            this.f1720a.setFov(f, f2, f3);
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
        if (this.f1720a != null) {
            this.M = i;
            this.f1720a.switchDisplayMode(i);
        }
    }

    public void switchInteractiveMode(int i) {
        if (this.f1720a != null) {
            this.L = i;
            this.f1720a.switchInteractiveMode(i);
        }
    }

    public void switchProjectionMode(int i) {
        if (this.f1720a != null) {
            this.N = i;
            this.f1720a.switchProjectionMode(i);
        }
    }
}
