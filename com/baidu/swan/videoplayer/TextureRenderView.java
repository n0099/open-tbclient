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
import com.baidu.tieba.ro4;
import com.baidu.tieba.so4;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@TargetApi(14)
/* loaded from: classes3.dex */
public class TextureRenderView extends TextureView implements ro4 {
    public so4 a;
    public int b;
    public SurfaceTexture c;
    public b d;

    @Override // com.baidu.tieba.ro4
    public View getView() {
        return this;
    }

    /* loaded from: classes3.dex */
    public static final class a implements ro4.b {
        public TextureRenderView a;

        public a(TextureRenderView textureRenderView) {
            this.a = textureRenderView;
        }

        @Override // com.baidu.tieba.ro4.b
        @TargetApi(16)
        public void a(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.a.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.a.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(c());
                } else if (!this.a.getLastSurfaceTexture().equals(this.a.getSurfaceTexture())) {
                    TextureRenderView textureRenderView = this.a;
                    textureRenderView.setSurfaceTexture(textureRenderView.getLastSurfaceTexture());
                }
                this.a.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.tieba.ro4.b
        public ro4 b() {
            return this.a;
        }

        public Surface c() {
            return new Surface(this.a.getSurfaceTexture());
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        public SurfaceTexture a;
        public boolean b;
        public int c;
        public int d;
        public WeakReference<TextureRenderView> f;
        public volatile boolean e = false;
        public Map<ro4.a, Object> g = new ConcurrentHashMap();

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public b(TextureRenderView textureRenderView) {
            this.f = new WeakReference<>(textureRenderView);
        }

        public void b(ro4.a aVar) {
            this.g.remove(aVar);
        }

        public void c(boolean z) {
            this.e = z;
        }

        public void a(ro4.a aVar) {
            a aVar2;
            this.g.put(aVar, aVar);
            if (this.a != null) {
                aVar2 = new a(this.f.get());
                aVar.b(aVar2, this.c, this.d);
            } else {
                aVar2 = null;
            }
            if (this.b) {
                if (aVar2 == null) {
                    aVar2 = new a(this.f.get());
                }
                aVar.c(aVar2, 0, this.c, this.d);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.a = surfaceTexture;
            this.b = false;
            this.c = 0;
            this.d = 0;
            a aVar = new a(this.f.get());
            for (ro4.a aVar2 : this.g.keySet()) {
                aVar2.a(aVar);
            }
            return this.e;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.a = surfaceTexture;
            if (this.f.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.f.get().getLastSurfaceTexture() == null) {
                this.f.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.b = false;
            this.c = 0;
            this.d = 0;
            a aVar = new a(this.f.get());
            for (ro4.a aVar2 : this.g.keySet()) {
                aVar2.b(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.a = surfaceTexture;
            this.b = true;
            this.c = i;
            this.d = i2;
            a aVar = new a(this.f.get());
            for (ro4.a aVar2 : this.g.keySet()) {
                aVar2.c(aVar, 0, i, i2);
            }
        }
    }

    public TextureRenderView(Context context) {
        super(context);
        this.b = 0;
        c(context);
    }

    @Override // com.baidu.tieba.ro4
    public void a(ro4.a aVar) {
        this.d.b(aVar);
    }

    @Override // com.baidu.tieba.ro4
    public void b(ro4.a aVar) {
        this.d.a(aVar);
    }

    public final void c(Context context) {
        this.a = new so4(this);
        b bVar = new b(this);
        this.d = bVar;
        setSurfaceTextureListener(bVar);
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

    @Override // com.baidu.tieba.ro4
    public void setAspectRatio(int i) {
        this.a.d(i);
        requestLayout();
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.b = i;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.c = surfaceTexture;
    }

    public void setVideoRotation(int i) {
        this.a.e(i);
        setRotation(i);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        c(context);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.a.a(i, i2);
        setMeasuredDimension(this.a.c(), this.a.b());
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.a.f(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.ro4
    public void setVideoSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.a.g(i, i2);
            requestLayout();
        }
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        c(context);
    }

    public int getCurrentMediaPlayerCode() {
        return this.b;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.c;
    }

    public ro4.b getSurfaceHolder() {
        return new a(this);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("TextureRenderView", "onDetachedFromWindow");
    }

    @Override // com.baidu.tieba.ro4
    @TargetApi(16)
    public void release() {
        if (this.c != null) {
            if (isAvailable()) {
                this.d.c(true);
                return;
            }
            this.c.release();
            this.c = null;
        }
    }
}
