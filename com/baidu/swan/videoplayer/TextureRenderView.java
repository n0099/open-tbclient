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
    public d.b.g0.s.b f13060e;

    /* renamed from: f  reason: collision with root package name */
    public int f13061f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f13062g;

    /* renamed from: h  reason: collision with root package name */
    public b f13063h;

    /* loaded from: classes3.dex */
    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public TextureRenderView f13064a;

        public a(TextureRenderView textureRenderView) {
            this.f13064a = textureRenderView;
        }

        @Override // d.b.g0.s.a.b
        @TargetApi(16)
        public void a(MediaPlayer mediaPlayer) {
            if (mediaPlayer == null || this.f13064a.getSurfaceTexture() == null) {
                return;
            }
            if (mediaPlayer.hashCode() != this.f13064a.getCurrentMediaPlayerCode()) {
                mediaPlayer.setSurface(c());
            } else if (!this.f13064a.getLastSurfaceTexture().equals(this.f13064a.getSurfaceTexture())) {
                TextureRenderView textureRenderView = this.f13064a;
                textureRenderView.setSurfaceTexture(textureRenderView.getLastSurfaceTexture());
            }
            this.f13064a.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
        }

        @Override // d.b.g0.s.a.b
        public d.b.g0.s.a b() {
            return this.f13064a;
        }

        public Surface c() {
            return new Surface(this.f13064a.getSurfaceTexture());
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements TextureView.SurfaceTextureListener {

        /* renamed from: e  reason: collision with root package name */
        public SurfaceTexture f13065e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f13066f;

        /* renamed from: g  reason: collision with root package name */
        public int f13067g;

        /* renamed from: h  reason: collision with root package name */
        public int f13068h;
        public WeakReference<TextureRenderView> j;
        public volatile boolean i = false;
        public Map<a.InterfaceC1031a, Object> k = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.j = new WeakReference<>(textureRenderView);
        }

        public void a(a.InterfaceC1031a interfaceC1031a) {
            a aVar;
            this.k.put(interfaceC1031a, interfaceC1031a);
            if (this.f13065e != null) {
                aVar = new a(this.j.get());
                interfaceC1031a.c(aVar, this.f13067g, this.f13068h);
            } else {
                aVar = null;
            }
            if (this.f13066f) {
                if (aVar == null) {
                    aVar = new a(this.j.get());
                }
                interfaceC1031a.a(aVar, 0, this.f13067g, this.f13068h);
            }
        }

        public void b(a.InterfaceC1031a interfaceC1031a) {
            this.k.remove(interfaceC1031a);
        }

        public void c(boolean z) {
            this.i = z;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f13065e = surfaceTexture;
            if (this.j.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.j.get().getLastSurfaceTexture() == null) {
                this.j.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.f13066f = false;
            this.f13067g = 0;
            this.f13068h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1031a interfaceC1031a : this.k.keySet()) {
                interfaceC1031a.c(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f13065e = surfaceTexture;
            this.f13066f = false;
            this.f13067g = 0;
            this.f13068h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1031a interfaceC1031a : this.k.keySet()) {
                interfaceC1031a.b(aVar);
            }
            return this.i;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f13065e = surfaceTexture;
            this.f13066f = true;
            this.f13067g = i;
            this.f13068h = i2;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1031a interfaceC1031a : this.k.keySet()) {
                interfaceC1031a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public TextureRenderView(Context context) {
        super(context);
        this.f13061f = 0;
        c(context);
    }

    @Override // d.b.g0.s.a
    public void a(a.InterfaceC1031a interfaceC1031a) {
        this.f13063h.b(interfaceC1031a);
    }

    @Override // d.b.g0.s.a
    public void b(a.InterfaceC1031a interfaceC1031a) {
        this.f13063h.a(interfaceC1031a);
    }

    public final void c(Context context) {
        this.f13060e = new d.b.g0.s.b(this);
        b bVar = new b(this);
        this.f13063h = bVar;
        setSurfaceTextureListener(bVar);
    }

    public int getCurrentMediaPlayerCode() {
        return this.f13061f;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.f13062g;
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
        this.f13060e.a(i, i2);
        setMeasuredDimension(this.f13060e.c(), this.f13060e.b());
    }

    @Override // d.b.g0.s.a
    @TargetApi(16)
    public void release() {
        if (this.f13062g != null) {
            if (isAvailable()) {
                this.f13063h.c(true);
                return;
            }
            this.f13062g.release();
            this.f13062g = null;
        }
    }

    @Override // d.b.g0.s.a
    public void setAspectRatio(int i) {
        this.f13060e.d(i);
        requestLayout();
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.f13061f = i;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.f13062g = surfaceTexture;
    }

    public void setVideoRotation(int i) {
        this.f13060e.e(i);
        setRotation(i);
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f13060e.f(i, i2);
        requestLayout();
    }

    @Override // d.b.g0.s.a
    public void setVideoSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f13060e.g(i, i2);
        requestLayout();
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13061f = 0;
        c(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13061f = 0;
        c(context);
    }
}
