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
    public d.a.l0.v.b f11884e;

    /* renamed from: f  reason: collision with root package name */
    public int f11885f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f11886g;

    /* renamed from: h  reason: collision with root package name */
    public b f11887h;

    /* loaded from: classes3.dex */
    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public TextureRenderView f11888a;

        public a(TextureRenderView textureRenderView) {
            this.f11888a = textureRenderView;
        }

        @Override // d.a.l0.v.a.b
        @TargetApi(16)
        public void a(MediaPlayer mediaPlayer) {
            if (mediaPlayer == null || this.f11888a.getSurfaceTexture() == null) {
                return;
            }
            if (mediaPlayer.hashCode() != this.f11888a.getCurrentMediaPlayerCode()) {
                mediaPlayer.setSurface(c());
            } else if (!this.f11888a.getLastSurfaceTexture().equals(this.f11888a.getSurfaceTexture())) {
                TextureRenderView textureRenderView = this.f11888a;
                textureRenderView.setSurfaceTexture(textureRenderView.getLastSurfaceTexture());
            }
            this.f11888a.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
        }

        @Override // d.a.l0.v.a.b
        public d.a.l0.v.a b() {
            return this.f11888a;
        }

        public Surface c() {
            return new Surface(this.f11888a.getSurfaceTexture());
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements TextureView.SurfaceTextureListener {

        /* renamed from: e  reason: collision with root package name */
        public SurfaceTexture f11889e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f11890f;

        /* renamed from: g  reason: collision with root package name */
        public int f11891g;

        /* renamed from: h  reason: collision with root package name */
        public int f11892h;
        public WeakReference<TextureRenderView> j;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f11893i = false;
        public Map<a.InterfaceC1087a, Object> k = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.j = new WeakReference<>(textureRenderView);
        }

        public void a(a.InterfaceC1087a interfaceC1087a) {
            a aVar;
            this.k.put(interfaceC1087a, interfaceC1087a);
            if (this.f11889e != null) {
                aVar = new a(this.j.get());
                interfaceC1087a.b(aVar, this.f11891g, this.f11892h);
            } else {
                aVar = null;
            }
            if (this.f11890f) {
                if (aVar == null) {
                    aVar = new a(this.j.get());
                }
                interfaceC1087a.c(aVar, 0, this.f11891g, this.f11892h);
            }
        }

        public void b(a.InterfaceC1087a interfaceC1087a) {
            this.k.remove(interfaceC1087a);
        }

        public void c(boolean z) {
            this.f11893i = z;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f11889e = surfaceTexture;
            if (this.j.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.j.get().getLastSurfaceTexture() == null) {
                this.j.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.f11890f = false;
            this.f11891g = 0;
            this.f11892h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1087a interfaceC1087a : this.k.keySet()) {
                interfaceC1087a.b(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f11889e = surfaceTexture;
            this.f11890f = false;
            this.f11891g = 0;
            this.f11892h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1087a interfaceC1087a : this.k.keySet()) {
                interfaceC1087a.a(aVar);
            }
            return this.f11893i;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f11889e = surfaceTexture;
            this.f11890f = true;
            this.f11891g = i2;
            this.f11892h = i3;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1087a interfaceC1087a : this.k.keySet()) {
                interfaceC1087a.c(aVar, 0, i2, i3);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public TextureRenderView(Context context) {
        super(context);
        this.f11885f = 0;
        c(context);
    }

    @Override // d.a.l0.v.a
    public void a(a.InterfaceC1087a interfaceC1087a) {
        this.f11887h.b(interfaceC1087a);
    }

    @Override // d.a.l0.v.a
    public void b(a.InterfaceC1087a interfaceC1087a) {
        this.f11887h.a(interfaceC1087a);
    }

    public final void c(Context context) {
        this.f11884e = new d.a.l0.v.b(this);
        b bVar = new b(this);
        this.f11887h = bVar;
        setSurfaceTextureListener(bVar);
    }

    public int getCurrentMediaPlayerCode() {
        return this.f11885f;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.f11886g;
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
        this.f11884e.a(i2, i3);
        setMeasuredDimension(this.f11884e.c(), this.f11884e.b());
    }

    @Override // d.a.l0.v.a
    @TargetApi(16)
    public void release() {
        if (this.f11886g != null) {
            if (isAvailable()) {
                this.f11887h.c(true);
                return;
            }
            this.f11886g.release();
            this.f11886g = null;
        }
    }

    @Override // d.a.l0.v.a
    public void setAspectRatio(int i2) {
        this.f11884e.d(i2);
        requestLayout();
    }

    public void setCurrentMediaPlayerCode(int i2) {
        this.f11885f = i2;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.f11886g = surfaceTexture;
    }

    public void setVideoRotation(int i2) {
        this.f11884e.e(i2);
        setRotation(i2);
    }

    public void setVideoSampleAspectRatio(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f11884e.f(i2, i3);
        requestLayout();
    }

    @Override // d.a.l0.v.a
    public void setVideoSize(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f11884e.g(i2, i3);
        requestLayout();
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11885f = 0;
        c(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11885f = 0;
        c(context);
    }
}
