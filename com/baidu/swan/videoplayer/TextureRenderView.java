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
import d.a.i0.v.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@TargetApi(14)
/* loaded from: classes3.dex */
public class TextureRenderView extends TextureView implements d.a.i0.v.a {

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.v.b f11983e;

    /* renamed from: f  reason: collision with root package name */
    public int f11984f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f11985g;

    /* renamed from: h  reason: collision with root package name */
    public b f11986h;

    /* loaded from: classes3.dex */
    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public TextureRenderView f11987a;

        public a(TextureRenderView textureRenderView) {
            this.f11987a = textureRenderView;
        }

        @Override // d.a.i0.v.a.b
        @TargetApi(16)
        public void a(MediaPlayer mediaPlayer) {
            if (mediaPlayer == null || this.f11987a.getSurfaceTexture() == null) {
                return;
            }
            if (mediaPlayer.hashCode() != this.f11987a.getCurrentMediaPlayerCode()) {
                mediaPlayer.setSurface(c());
            } else if (!this.f11987a.getLastSurfaceTexture().equals(this.f11987a.getSurfaceTexture())) {
                TextureRenderView textureRenderView = this.f11987a;
                textureRenderView.setSurfaceTexture(textureRenderView.getLastSurfaceTexture());
            }
            this.f11987a.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
        }

        @Override // d.a.i0.v.a.b
        public d.a.i0.v.a b() {
            return this.f11987a;
        }

        public Surface c() {
            return new Surface(this.f11987a.getSurfaceTexture());
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements TextureView.SurfaceTextureListener {

        /* renamed from: e  reason: collision with root package name */
        public SurfaceTexture f11988e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f11989f;

        /* renamed from: g  reason: collision with root package name */
        public int f11990g;

        /* renamed from: h  reason: collision with root package name */
        public int f11991h;
        public WeakReference<TextureRenderView> j;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f11992i = false;
        public Map<a.InterfaceC1076a, Object> k = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.j = new WeakReference<>(textureRenderView);
        }

        public void a(a.InterfaceC1076a interfaceC1076a) {
            a aVar;
            this.k.put(interfaceC1076a, interfaceC1076a);
            if (this.f11988e != null) {
                aVar = new a(this.j.get());
                interfaceC1076a.b(aVar, this.f11990g, this.f11991h);
            } else {
                aVar = null;
            }
            if (this.f11989f) {
                if (aVar == null) {
                    aVar = new a(this.j.get());
                }
                interfaceC1076a.c(aVar, 0, this.f11990g, this.f11991h);
            }
        }

        public void b(a.InterfaceC1076a interfaceC1076a) {
            this.k.remove(interfaceC1076a);
        }

        public void c(boolean z) {
            this.f11992i = z;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f11988e = surfaceTexture;
            if (this.j.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.j.get().getLastSurfaceTexture() == null) {
                this.j.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.f11989f = false;
            this.f11990g = 0;
            this.f11991h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1076a interfaceC1076a : this.k.keySet()) {
                interfaceC1076a.b(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f11988e = surfaceTexture;
            this.f11989f = false;
            this.f11990g = 0;
            this.f11991h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1076a interfaceC1076a : this.k.keySet()) {
                interfaceC1076a.a(aVar);
            }
            return this.f11992i;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f11988e = surfaceTexture;
            this.f11989f = true;
            this.f11990g = i2;
            this.f11991h = i3;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1076a interfaceC1076a : this.k.keySet()) {
                interfaceC1076a.c(aVar, 0, i2, i3);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public TextureRenderView(Context context) {
        super(context);
        this.f11984f = 0;
        c(context);
    }

    @Override // d.a.i0.v.a
    public void a(a.InterfaceC1076a interfaceC1076a) {
        this.f11986h.b(interfaceC1076a);
    }

    @Override // d.a.i0.v.a
    public void b(a.InterfaceC1076a interfaceC1076a) {
        this.f11986h.a(interfaceC1076a);
    }

    public final void c(Context context) {
        this.f11983e = new d.a.i0.v.b(this);
        b bVar = new b(this);
        this.f11986h = bVar;
        setSurfaceTextureListener(bVar);
    }

    public int getCurrentMediaPlayerCode() {
        return this.f11984f;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.f11985g;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    @Override // d.a.i0.v.a
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
        this.f11983e.a(i2, i3);
        setMeasuredDimension(this.f11983e.c(), this.f11983e.b());
    }

    @Override // d.a.i0.v.a
    @TargetApi(16)
    public void release() {
        if (this.f11985g != null) {
            if (isAvailable()) {
                this.f11986h.c(true);
                return;
            }
            this.f11985g.release();
            this.f11985g = null;
        }
    }

    @Override // d.a.i0.v.a
    public void setAspectRatio(int i2) {
        this.f11983e.d(i2);
        requestLayout();
    }

    public void setCurrentMediaPlayerCode(int i2) {
        this.f11984f = i2;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.f11985g = surfaceTexture;
    }

    public void setVideoRotation(int i2) {
        this.f11983e.e(i2);
        setRotation(i2);
    }

    public void setVideoSampleAspectRatio(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f11983e.f(i2, i3);
        requestLayout();
    }

    @Override // d.a.i0.v.a
    public void setVideoSize(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f11983e.g(i2, i3);
        requestLayout();
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11984f = 0;
        c(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11984f = 0;
        c(context);
    }
}
