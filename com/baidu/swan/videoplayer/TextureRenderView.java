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
import d.b.g0.s.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@TargetApi(14)
/* loaded from: classes3.dex */
public class TextureRenderView extends TextureView implements d.b.g0.s.a {

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.s.b f13059e;

    /* renamed from: f  reason: collision with root package name */
    public int f13060f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f13061g;

    /* renamed from: h  reason: collision with root package name */
    public b f13062h;

    /* loaded from: classes3.dex */
    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public TextureRenderView f13063a;

        public a(TextureRenderView textureRenderView) {
            this.f13063a = textureRenderView;
        }

        @Override // d.b.g0.s.a.b
        @TargetApi(16)
        public void a(MediaPlayer mediaPlayer) {
            if (mediaPlayer == null || this.f13063a.getSurfaceTexture() == null) {
                return;
            }
            if (mediaPlayer.hashCode() != this.f13063a.getCurrentMediaPlayerCode()) {
                mediaPlayer.setSurface(c());
            } else if (!this.f13063a.getLastSurfaceTexture().equals(this.f13063a.getSurfaceTexture())) {
                TextureRenderView textureRenderView = this.f13063a;
                textureRenderView.setSurfaceTexture(textureRenderView.getLastSurfaceTexture());
            }
            this.f13063a.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
        }

        @Override // d.b.g0.s.a.b
        public d.b.g0.s.a b() {
            return this.f13063a;
        }

        public Surface c() {
            return new Surface(this.f13063a.getSurfaceTexture());
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements TextureView.SurfaceTextureListener {

        /* renamed from: e  reason: collision with root package name */
        public SurfaceTexture f13064e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f13065f;

        /* renamed from: g  reason: collision with root package name */
        public int f13066g;

        /* renamed from: h  reason: collision with root package name */
        public int f13067h;
        public WeakReference<TextureRenderView> j;
        public volatile boolean i = false;
        public Map<a.InterfaceC1030a, Object> k = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.j = new WeakReference<>(textureRenderView);
        }

        public void a(a.InterfaceC1030a interfaceC1030a) {
            a aVar;
            this.k.put(interfaceC1030a, interfaceC1030a);
            if (this.f13064e != null) {
                aVar = new a(this.j.get());
                interfaceC1030a.c(aVar, this.f13066g, this.f13067h);
            } else {
                aVar = null;
            }
            if (this.f13065f) {
                if (aVar == null) {
                    aVar = new a(this.j.get());
                }
                interfaceC1030a.a(aVar, 0, this.f13066g, this.f13067h);
            }
        }

        public void b(a.InterfaceC1030a interfaceC1030a) {
            this.k.remove(interfaceC1030a);
        }

        public void c(boolean z) {
            this.i = z;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f13064e = surfaceTexture;
            if (this.j.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.j.get().getLastSurfaceTexture() == null) {
                this.j.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.f13065f = false;
            this.f13066g = 0;
            this.f13067h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1030a interfaceC1030a : this.k.keySet()) {
                interfaceC1030a.c(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f13064e = surfaceTexture;
            this.f13065f = false;
            this.f13066g = 0;
            this.f13067h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1030a interfaceC1030a : this.k.keySet()) {
                interfaceC1030a.b(aVar);
            }
            return this.i;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f13064e = surfaceTexture;
            this.f13065f = true;
            this.f13066g = i;
            this.f13067h = i2;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1030a interfaceC1030a : this.k.keySet()) {
                interfaceC1030a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public TextureRenderView(Context context) {
        super(context);
        this.f13060f = 0;
        c(context);
    }

    @Override // d.b.g0.s.a
    public void a(a.InterfaceC1030a interfaceC1030a) {
        this.f13062h.b(interfaceC1030a);
    }

    @Override // d.b.g0.s.a
    public void b(a.InterfaceC1030a interfaceC1030a) {
        this.f13062h.a(interfaceC1030a);
    }

    public final void c(Context context) {
        this.f13059e = new d.b.g0.s.b(this);
        b bVar = new b(this);
        this.f13062h = bVar;
        setSurfaceTextureListener(bVar);
    }

    public int getCurrentMediaPlayerCode() {
        return this.f13060f;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.f13061g;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    @Override // d.b.g0.s.a
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
    public void onMeasure(int i, int i2) {
        this.f13059e.a(i, i2);
        setMeasuredDimension(this.f13059e.c(), this.f13059e.b());
    }

    @Override // d.b.g0.s.a
    @TargetApi(16)
    public void release() {
        if (this.f13061g != null) {
            if (isAvailable()) {
                this.f13062h.c(true);
                return;
            }
            this.f13061g.release();
            this.f13061g = null;
        }
    }

    @Override // d.b.g0.s.a
    public void setAspectRatio(int i) {
        this.f13059e.d(i);
        requestLayout();
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.f13060f = i;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.f13061g = surfaceTexture;
    }

    public void setVideoRotation(int i) {
        this.f13059e.e(i);
        setRotation(i);
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f13059e.f(i, i2);
        requestLayout();
    }

    @Override // d.b.g0.s.a
    public void setVideoSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f13059e.g(i, i2);
        requestLayout();
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13060f = 0;
        c(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13060f = 0;
        c(context);
    }
}
