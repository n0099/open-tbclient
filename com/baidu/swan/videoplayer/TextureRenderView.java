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
import com.baidu.swan.videoplayer.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@TargetApi(14)
/* loaded from: classes25.dex */
public class TextureRenderView extends TextureView implements com.baidu.swan.videoplayer.a {
    private int dNA;
    private SurfaceTexture dNB;
    public b dNC;
    private com.baidu.swan.videoplayer.b dNz;

    public TextureRenderView(Context context) {
        super(context);
        this.dNA = 0;
        dK(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dNA = 0;
        dK(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dNA = 0;
        dK(context);
    }

    private void dK(Context context) {
        this.dNz = new com.baidu.swan.videoplayer.b(this);
        this.dNC = new b(this);
        setSurfaceTextureListener(this.dNC);
    }

    @Override // com.baidu.swan.videoplayer.a
    public View getView() {
        return this;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("TextureRenderView", "onDetachedFromWindow");
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setVideoSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.dNz.setVideoSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.dNz.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.dNz.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setAspectRatio(int i) {
        this.dNz.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dNz.aG(i, i2);
        setMeasuredDimension(this.dNz.aXw(), this.dNz.aXx());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.dNA = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.dNA;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.dNB;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.dNB = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static final class a implements a.b {
        private TextureRenderView dND;

        public a(TextureRenderView textureRenderView) {
            this.dND = textureRenderView;
        }

        @Override // com.baidu.swan.videoplayer.a.b
        @TargetApi(16)
        public void b(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.dND.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.dND.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(aXE());
                } else if (!this.dND.getLastSurfaceTexture().equals(this.dND.getSurfaceTexture())) {
                    this.dND.setSurfaceTexture(this.dND.getLastSurfaceTexture());
                }
                this.dND.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b
        public com.baidu.swan.videoplayer.a aXv() {
            return this.dND;
        }

        public Surface aXE() {
            return new Surface(this.dND.getSurfaceTexture());
        }
    }

    @Override // com.baidu.swan.videoplayer.a
    public void a(a.InterfaceC0521a interfaceC0521a) {
        this.dNC.a(interfaceC0521a);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void b(a.InterfaceC0521a interfaceC0521a) {
        this.dNC.b(interfaceC0521a);
    }

    @Override // com.baidu.swan.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.dNB != null) {
            if (isAvailable()) {
                this.dNC.hj(true);
                return;
            }
            this.dNB.release();
            this.dNB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean dNE;
        private WeakReference<TextureRenderView> dNG;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean dNF = false;
        private Map<a.InterfaceC0521a, Object> dNH = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.dNG = new WeakReference<>(textureRenderView);
        }

        public void hj(boolean z) {
            this.dNF = z;
        }

        public void a(a.InterfaceC0521a interfaceC0521a) {
            this.dNH.put(interfaceC0521a, interfaceC0521a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.dNG.get());
                }
                interfaceC0521a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.dNE) {
                if (aVar == null) {
                    aVar = new a(this.dNG.get());
                }
                interfaceC0521a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0521a interfaceC0521a) {
            this.dNH.remove(interfaceC0521a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.dNG.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.dNG.get().getLastSurfaceTexture() == null) {
                this.dNG.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.dNE = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dNG.get());
            for (a.InterfaceC0521a interfaceC0521a : this.dNH.keySet()) {
                interfaceC0521a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.dNE = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.dNG.get());
            for (a.InterfaceC0521a interfaceC0521a : this.dNH.keySet()) {
                interfaceC0521a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.dNE = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dNG.get());
            for (a.InterfaceC0521a interfaceC0521a : this.dNH.keySet()) {
                interfaceC0521a.a(aVar);
            }
            return this.dNF;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
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
}
