package com.baidu.swan.videoplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import d.a.m0.v.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@TargetApi(14)
/* loaded from: classes3.dex */
public class TextureRenderView extends TextureView implements d.a.m0.v.a {

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.v.b f12028e;

    /* renamed from: f  reason: collision with root package name */
    public int f12029f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f12030g;

    /* renamed from: h  reason: collision with root package name */
    public b f12031h;

    /* loaded from: classes3.dex */
    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public TextureRenderView f12032a;

        public a(TextureRenderView textureRenderView) {
            this.f12032a = textureRenderView;
        }

        @Override // d.a.m0.v.a.b
        @TargetApi(16)
        public void a(MediaPlayer mediaPlayer) {
            if (mediaPlayer == null || this.f12032a.getSurfaceTexture() == null) {
                return;
            }
            if (mediaPlayer.hashCode() != this.f12032a.getCurrentMediaPlayerCode()) {
                mediaPlayer.setSurface(c());
            } else if (!this.f12032a.getLastSurfaceTexture().equals(this.f12032a.getSurfaceTexture())) {
                TextureRenderView textureRenderView = this.f12032a;
                textureRenderView.setSurfaceTexture(textureRenderView.getLastSurfaceTexture());
            }
            this.f12032a.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
        }

        @Override // d.a.m0.v.a.b
        public d.a.m0.v.a b() {
            return this.f12032a;
        }

        public Surface c() {
            return new Surface(this.f12032a.getSurfaceTexture());
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements TextureView.SurfaceTextureListener {

        /* renamed from: e  reason: collision with root package name */
        public SurfaceTexture f12033e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f12034f;

        /* renamed from: g  reason: collision with root package name */
        public int f12035g;

        /* renamed from: h  reason: collision with root package name */
        public int f12036h;
        public WeakReference<TextureRenderView> j;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f12037i = false;
        public Map<a.InterfaceC1146a, Object> k = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.j = new WeakReference<>(textureRenderView);
        }

        public void a(a.InterfaceC1146a interfaceC1146a) {
            a aVar;
            this.k.put(interfaceC1146a, interfaceC1146a);
            if (this.f12033e != null) {
                aVar = new a(this.j.get());
                interfaceC1146a.b(aVar, this.f12035g, this.f12036h);
            } else {
                aVar = null;
            }
            if (this.f12034f) {
                if (aVar == null) {
                    aVar = new a(this.j.get());
                }
                interfaceC1146a.c(aVar, 0, this.f12035g, this.f12036h);
            }
        }

        public void b(a.InterfaceC1146a interfaceC1146a) {
            this.k.remove(interfaceC1146a);
        }

        public void c(boolean z) {
            this.f12037i = z;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f12033e = surfaceTexture;
            if (this.j.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.j.get().getLastSurfaceTexture() == null) {
                this.j.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.f12034f = false;
            this.f12035g = 0;
            this.f12036h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1146a interfaceC1146a : this.k.keySet()) {
                interfaceC1146a.b(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f12033e = surfaceTexture;
            this.f12034f = false;
            this.f12035g = 0;
            this.f12036h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1146a interfaceC1146a : this.k.keySet()) {
                interfaceC1146a.a(aVar);
            }
            return this.f12037i;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f12033e = surfaceTexture;
            this.f12034f = true;
            this.f12035g = i2;
            this.f12036h = i3;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1146a interfaceC1146a : this.k.keySet()) {
                interfaceC1146a.c(aVar, 0, i2, i3);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public TextureRenderView(Context context) {
        super(context);
        this.f12029f = 0;
        c(context);
    }

    @Override // d.a.m0.v.a
    public void a(a.InterfaceC1146a interfaceC1146a) {
        this.f12031h.b(interfaceC1146a);
    }

    @Override // d.a.m0.v.a
    public void b(a.InterfaceC1146a interfaceC1146a) {
        this.f12031h.a(interfaceC1146a);
    }

    public final void c(Context context) {
        this.f12028e = new d.a.m0.v.b(this);
        b bVar = new b(this);
        this.f12031h = bVar;
        setSurfaceTextureListener(bVar);
    }

    public int getCurrentMediaPlayerCode() {
        return this.f12029f;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.f12030g;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    @Override // d.a.m0.v.a
    public View getView() {
        return this;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("TextureRenderView", "onDetachedFromWindow");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureRenderView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureRenderView.class.getName());
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        this.f12028e.a(i2, i3);
        setMeasuredDimension(this.f12028e.c(), this.f12028e.b());
    }

    @Override // d.a.m0.v.a
    @TargetApi(16)
    public void release() {
        if (this.f12030g != null) {
            if (isAvailable()) {
                this.f12031h.c(true);
                return;
            }
            this.f12030g.release();
            this.f12030g = null;
        }
    }

    @Override // d.a.m0.v.a
    public void setAspectRatio(int i2) {
        this.f12028e.d(i2);
        requestLayout();
    }

    public void setCurrentMediaPlayerCode(int i2) {
        this.f12029f = i2;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.f12030g = surfaceTexture;
    }

    public void setVideoRotation(int i2) {
        this.f12028e.e(i2);
        setRotation(i2);
    }

    public void setVideoSampleAspectRatio(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f12028e.f(i2, i3);
        requestLayout();
    }

    @Override // d.a.m0.v.a
    public void setVideoSize(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f12028e.g(i2, i3);
        requestLayout();
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12029f = 0;
        c(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12029f = 0;
        c(context);
    }
}
