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
import d.a.h0.s.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@TargetApi(14)
/* loaded from: classes3.dex */
public class TextureRenderView extends TextureView implements d.a.h0.s.a {

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.s.b f12639e;

    /* renamed from: f  reason: collision with root package name */
    public int f12640f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f12641g;

    /* renamed from: h  reason: collision with root package name */
    public b f12642h;

    /* loaded from: classes3.dex */
    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public TextureRenderView f12643a;

        public a(TextureRenderView textureRenderView) {
            this.f12643a = textureRenderView;
        }

        @Override // d.a.h0.s.a.b
        @TargetApi(16)
        public void a(MediaPlayer mediaPlayer) {
            if (mediaPlayer == null || this.f12643a.getSurfaceTexture() == null) {
                return;
            }
            if (mediaPlayer.hashCode() != this.f12643a.getCurrentMediaPlayerCode()) {
                mediaPlayer.setSurface(c());
            } else if (!this.f12643a.getLastSurfaceTexture().equals(this.f12643a.getSurfaceTexture())) {
                TextureRenderView textureRenderView = this.f12643a;
                textureRenderView.setSurfaceTexture(textureRenderView.getLastSurfaceTexture());
            }
            this.f12643a.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
        }

        @Override // d.a.h0.s.a.b
        public d.a.h0.s.a b() {
            return this.f12643a;
        }

        public Surface c() {
            return new Surface(this.f12643a.getSurfaceTexture());
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements TextureView.SurfaceTextureListener {

        /* renamed from: e  reason: collision with root package name */
        public SurfaceTexture f12644e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f12645f;

        /* renamed from: g  reason: collision with root package name */
        public int f12646g;

        /* renamed from: h  reason: collision with root package name */
        public int f12647h;
        public WeakReference<TextureRenderView> j;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f12648i = false;
        public Map<a.InterfaceC1002a, Object> k = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.j = new WeakReference<>(textureRenderView);
        }

        public void a(a.InterfaceC1002a interfaceC1002a) {
            a aVar;
            this.k.put(interfaceC1002a, interfaceC1002a);
            if (this.f12644e != null) {
                aVar = new a(this.j.get());
                interfaceC1002a.b(aVar, this.f12646g, this.f12647h);
            } else {
                aVar = null;
            }
            if (this.f12645f) {
                if (aVar == null) {
                    aVar = new a(this.j.get());
                }
                interfaceC1002a.c(aVar, 0, this.f12646g, this.f12647h);
            }
        }

        public void b(a.InterfaceC1002a interfaceC1002a) {
            this.k.remove(interfaceC1002a);
        }

        public void c(boolean z) {
            this.f12648i = z;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f12644e = surfaceTexture;
            if (this.j.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.j.get().getLastSurfaceTexture() == null) {
                this.j.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.f12645f = false;
            this.f12646g = 0;
            this.f12647h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1002a interfaceC1002a : this.k.keySet()) {
                interfaceC1002a.b(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f12644e = surfaceTexture;
            this.f12645f = false;
            this.f12646g = 0;
            this.f12647h = 0;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1002a interfaceC1002a : this.k.keySet()) {
                interfaceC1002a.a(aVar);
            }
            return this.f12648i;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f12644e = surfaceTexture;
            this.f12645f = true;
            this.f12646g = i2;
            this.f12647h = i3;
            a aVar = new a(this.j.get());
            for (a.InterfaceC1002a interfaceC1002a : this.k.keySet()) {
                interfaceC1002a.c(aVar, 0, i2, i3);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public TextureRenderView(Context context) {
        super(context);
        this.f12640f = 0;
        c(context);
    }

    @Override // d.a.h0.s.a
    public void a(a.InterfaceC1002a interfaceC1002a) {
        this.f12642h.b(interfaceC1002a);
    }

    @Override // d.a.h0.s.a
    public void b(a.InterfaceC1002a interfaceC1002a) {
        this.f12642h.a(interfaceC1002a);
    }

    public final void c(Context context) {
        this.f12639e = new d.a.h0.s.b(this);
        b bVar = new b(this);
        this.f12642h = bVar;
        setSurfaceTextureListener(bVar);
    }

    public int getCurrentMediaPlayerCode() {
        return this.f12640f;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.f12641g;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    @Override // d.a.h0.s.a
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
        this.f12639e.a(i2, i3);
        setMeasuredDimension(this.f12639e.c(), this.f12639e.b());
    }

    @Override // d.a.h0.s.a
    @TargetApi(16)
    public void release() {
        if (this.f12641g != null) {
            if (isAvailable()) {
                this.f12642h.c(true);
                return;
            }
            this.f12641g.release();
            this.f12641g = null;
        }
    }

    @Override // d.a.h0.s.a
    public void setAspectRatio(int i2) {
        this.f12639e.d(i2);
        requestLayout();
    }

    public void setCurrentMediaPlayerCode(int i2) {
        this.f12640f = i2;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.f12641g = surfaceTexture;
    }

    public void setVideoRotation(int i2) {
        this.f12639e.e(i2);
        setRotation(i2);
    }

    public void setVideoSampleAspectRatio(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f12639e.f(i2, i3);
        requestLayout();
    }

    @Override // d.a.h0.s.a
    public void setVideoSize(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f12639e.g(i2, i3);
        requestLayout();
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12640f = 0;
        c(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12640f = 0;
        c(context);
    }
}
