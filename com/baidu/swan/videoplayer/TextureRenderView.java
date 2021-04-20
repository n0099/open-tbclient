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
    public d.b.g0.s.b f12721e;

    /* renamed from: f  reason: collision with root package name */
    public int f12722f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f12723g;

    /* renamed from: h  reason: collision with root package name */
    public b f12724h;

    /* loaded from: classes3.dex */
    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public TextureRenderView f12725a;

        public a(TextureRenderView textureRenderView) {
            this.f12725a = textureRenderView;
        }

        @Override // d.b.g0.s.a.b
        @TargetApi(16)
        public void a(MediaPlayer mediaPlayer) {
            if (mediaPlayer == null || this.f12725a.getSurfaceTexture() == null) {
                return;
            }
            if (mediaPlayer.hashCode() != this.f12725a.getCurrentMediaPlayerCode()) {
                mediaPlayer.setSurface(c());
            } else if (!this.f12725a.getLastSurfaceTexture().equals(this.f12725a.getSurfaceTexture())) {
                TextureRenderView textureRenderView = this.f12725a;
                textureRenderView.setSurfaceTexture(textureRenderView.getLastSurfaceTexture());
            }
            this.f12725a.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
        }

        @Override // d.b.g0.s.a.b
        public d.b.g0.s.a b() {
            return this.f12725a;
        }

        public Surface c() {
            return new Surface(this.f12725a.getSurfaceTexture());
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements TextureView.SurfaceTextureListener {

        /* renamed from: e  reason: collision with root package name */
        public SurfaceTexture f12726e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f12727f;

        /* renamed from: g  reason: collision with root package name */
        public int f12728g;

        /* renamed from: h  reason: collision with root package name */
        public int f12729h;
        public WeakReference<TextureRenderView> j;
        public volatile boolean i = false;
        public Map<a.InterfaceC1043a, Object> k = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.j = new WeakReference<>(textureRenderView);
        }

        public void a(a.InterfaceC1043a interfaceC1043a) {
            a aVar;
            this.k.put(interfaceC1043a, interfaceC1043a);
            if (this.f12726e != null) {
                aVar = new a(this.j.get());
                interfaceC1043a.c(aVar, this.f12728g, this.f12729h);
            } else {
                aVar = null;
            }
            if (this.f12727f) {
                if (aVar == null) {
                    aVar = new a(this.j.get());
                }
                interfaceC1043a.a(aVar, 0, this.f12728g, this.f12729h);
            }
        }

        public void b(a.InterfaceC1043a interfaceC1043a) {
            this.k.remove(interfaceC1043a);
        }

        public void c(boolean z) {
            this.i = z;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f12726e = surfaceTexture;
            if (this.j.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.j.get().getLastSurfaceTexture() == null) {
                this.j.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.f12727f = false;
            this.f12728g = 0;
            this.f12729h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1043a interfaceC1043a : this.k.keySet()) {
                interfaceC1043a.c(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f12726e = surfaceTexture;
            this.f12727f = false;
            this.f12728g = 0;
            this.f12729h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1043a interfaceC1043a : this.k.keySet()) {
                interfaceC1043a.b(aVar);
            }
            return this.i;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f12726e = surfaceTexture;
            this.f12727f = true;
            this.f12728g = i;
            this.f12729h = i2;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1043a interfaceC1043a : this.k.keySet()) {
                interfaceC1043a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public TextureRenderView(Context context) {
        super(context);
        this.f12722f = 0;
        c(context);
    }

    @Override // d.b.g0.s.a
    public void a(a.InterfaceC1043a interfaceC1043a) {
        this.f12724h.b(interfaceC1043a);
    }

    @Override // d.b.g0.s.a
    public void b(a.InterfaceC1043a interfaceC1043a) {
        this.f12724h.a(interfaceC1043a);
    }

    public final void c(Context context) {
        this.f12721e = new d.b.g0.s.b(this);
        b bVar = new b(this);
        this.f12724h = bVar;
        setSurfaceTextureListener(bVar);
    }

    public int getCurrentMediaPlayerCode() {
        return this.f12722f;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.f12723g;
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
        this.f12721e.a(i, i2);
        setMeasuredDimension(this.f12721e.c(), this.f12721e.b());
    }

    @Override // d.b.g0.s.a
    @TargetApi(16)
    public void release() {
        if (this.f12723g != null) {
            if (isAvailable()) {
                this.f12724h.c(true);
                return;
            }
            this.f12723g.release();
            this.f12723g = null;
        }
    }

    @Override // d.b.g0.s.a
    public void setAspectRatio(int i) {
        this.f12721e.d(i);
        requestLayout();
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.f12722f = i;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.f12723g = surfaceTexture;
    }

    public void setVideoRotation(int i) {
        this.f12721e.e(i);
        setRotation(i);
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f12721e.f(i, i2);
        requestLayout();
    }

    @Override // d.b.g0.s.a
    public void setVideoSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f12721e.g(i, i2);
        requestLayout();
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12722f = 0;
        c(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12722f = 0;
        c(context);
    }
}
