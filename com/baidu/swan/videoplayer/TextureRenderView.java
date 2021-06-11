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
import d.a.l0.v.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@TargetApi(14)
/* loaded from: classes3.dex */
public class TextureRenderView extends TextureView implements d.a.l0.v.a {

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.v.b f11946e;

    /* renamed from: f  reason: collision with root package name */
    public int f11947f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f11948g;

    /* renamed from: h  reason: collision with root package name */
    public b f11949h;

    /* loaded from: classes3.dex */
    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public TextureRenderView f11950a;

        public a(TextureRenderView textureRenderView) {
            this.f11950a = textureRenderView;
        }

        @Override // d.a.l0.v.a.b
        @TargetApi(16)
        public void a(MediaPlayer mediaPlayer) {
            if (mediaPlayer == null || this.f11950a.getSurfaceTexture() == null) {
                return;
            }
            if (mediaPlayer.hashCode() != this.f11950a.getCurrentMediaPlayerCode()) {
                mediaPlayer.setSurface(c());
            } else if (!this.f11950a.getLastSurfaceTexture().equals(this.f11950a.getSurfaceTexture())) {
                TextureRenderView textureRenderView = this.f11950a;
                textureRenderView.setSurfaceTexture(textureRenderView.getLastSurfaceTexture());
            }
            this.f11950a.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
        }

        @Override // d.a.l0.v.a.b
        public d.a.l0.v.a b() {
            return this.f11950a;
        }

        public Surface c() {
            return new Surface(this.f11950a.getSurfaceTexture());
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements TextureView.SurfaceTextureListener {

        /* renamed from: e  reason: collision with root package name */
        public SurfaceTexture f11951e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f11952f;

        /* renamed from: g  reason: collision with root package name */
        public int f11953g;

        /* renamed from: h  reason: collision with root package name */
        public int f11954h;
        public WeakReference<TextureRenderView> j;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f11955i = false;
        public Map<a.InterfaceC1143a, Object> k = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.j = new WeakReference<>(textureRenderView);
        }

        public void a(a.InterfaceC1143a interfaceC1143a) {
            a aVar;
            this.k.put(interfaceC1143a, interfaceC1143a);
            if (this.f11951e != null) {
                aVar = new a(this.j.get());
                interfaceC1143a.b(aVar, this.f11953g, this.f11954h);
            } else {
                aVar = null;
            }
            if (this.f11952f) {
                if (aVar == null) {
                    aVar = new a(this.j.get());
                }
                interfaceC1143a.c(aVar, 0, this.f11953g, this.f11954h);
            }
        }

        public void b(a.InterfaceC1143a interfaceC1143a) {
            this.k.remove(interfaceC1143a);
        }

        public void c(boolean z) {
            this.f11955i = z;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f11951e = surfaceTexture;
            if (this.j.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.j.get().getLastSurfaceTexture() == null) {
                this.j.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.f11952f = false;
            this.f11953g = 0;
            this.f11954h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1143a interfaceC1143a : this.k.keySet()) {
                interfaceC1143a.b(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f11951e = surfaceTexture;
            this.f11952f = false;
            this.f11953g = 0;
            this.f11954h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1143a interfaceC1143a : this.k.keySet()) {
                interfaceC1143a.a(aVar);
            }
            return this.f11955i;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f11951e = surfaceTexture;
            this.f11952f = true;
            this.f11953g = i2;
            this.f11954h = i3;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1143a interfaceC1143a : this.k.keySet()) {
                interfaceC1143a.c(aVar, 0, i2, i3);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public TextureRenderView(Context context) {
        super(context);
        this.f11947f = 0;
        c(context);
    }

    @Override // d.a.l0.v.a
    public void a(a.InterfaceC1143a interfaceC1143a) {
        this.f11949h.b(interfaceC1143a);
    }

    @Override // d.a.l0.v.a
    public void b(a.InterfaceC1143a interfaceC1143a) {
        this.f11949h.a(interfaceC1143a);
    }

    public final void c(Context context) {
        this.f11946e = new d.a.l0.v.b(this);
        b bVar = new b(this);
        this.f11949h = bVar;
        setSurfaceTextureListener(bVar);
    }

    public int getCurrentMediaPlayerCode() {
        return this.f11947f;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.f11948g;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    @Override // d.a.l0.v.a
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
        this.f11946e.a(i2, i3);
        setMeasuredDimension(this.f11946e.c(), this.f11946e.b());
    }

    @Override // d.a.l0.v.a
    @TargetApi(16)
    public void release() {
        if (this.f11948g != null) {
            if (isAvailable()) {
                this.f11949h.c(true);
                return;
            }
            this.f11948g.release();
            this.f11948g = null;
        }
    }

    @Override // d.a.l0.v.a
    public void setAspectRatio(int i2) {
        this.f11946e.d(i2);
        requestLayout();
    }

    public void setCurrentMediaPlayerCode(int i2) {
        this.f11947f = i2;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.f11948g = surfaceTexture;
    }

    public void setVideoRotation(int i2) {
        this.f11946e.e(i2);
        setRotation(i2);
    }

    public void setVideoSampleAspectRatio(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f11946e.f(i2, i3);
        requestLayout();
    }

    @Override // d.a.l0.v.a
    public void setVideoSize(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f11946e.g(i2, i3);
        requestLayout();
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11947f = 0;
        c(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11947f = 0;
        c(context);
    }
}
