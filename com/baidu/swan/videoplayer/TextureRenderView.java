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
/* loaded from: classes12.dex */
public class TextureRenderView extends TextureView implements com.baidu.swan.videoplayer.a {
    private com.baidu.swan.videoplayer.b ehX;
    private int ehY;
    private SurfaceTexture ehZ;
    public b eia;

    public TextureRenderView(Context context) {
        super(context);
        this.ehY = 0;
        dQ(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ehY = 0;
        dQ(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ehY = 0;
        dQ(context);
    }

    private void dQ(Context context) {
        this.ehX = new com.baidu.swan.videoplayer.b(this);
        this.eia = new b(this);
        setSurfaceTextureListener(this.eia);
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
            this.ehX.setVideoSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.ehX.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.ehX.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setAspectRatio(int i) {
        this.ehX.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.ehX.aG(i, i2);
        setMeasuredDimension(this.ehX.bbX(), this.ehX.bbY());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.ehY = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.ehY;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.ehZ;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.ehZ = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class a implements a.b {
        private TextureRenderView eib;

        public a(TextureRenderView textureRenderView) {
            this.eib = textureRenderView;
        }

        @Override // com.baidu.swan.videoplayer.a.b
        @TargetApi(16)
        public void b(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.eib.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.eib.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(bcf());
                } else if (!this.eib.getLastSurfaceTexture().equals(this.eib.getSurfaceTexture())) {
                    this.eib.setSurfaceTexture(this.eib.getLastSurfaceTexture());
                }
                this.eib.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b
        public com.baidu.swan.videoplayer.a bbW() {
            return this.eib;
        }

        public Surface bcf() {
            return new Surface(this.eib.getSurfaceTexture());
        }
    }

    @Override // com.baidu.swan.videoplayer.a
    public void a(a.InterfaceC0552a interfaceC0552a) {
        this.eia.a(interfaceC0552a);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void b(a.InterfaceC0552a interfaceC0552a) {
        this.eia.b(interfaceC0552a);
    }

    @Override // com.baidu.swan.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.ehZ != null) {
            if (isAvailable()) {
                this.eia.hS(true);
                return;
            }
            this.ehZ.release();
            this.ehZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean eic;
        private WeakReference<TextureRenderView> eie;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean eid = false;
        private Map<a.InterfaceC0552a, Object> eif = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.eie = new WeakReference<>(textureRenderView);
        }

        public void hS(boolean z) {
            this.eid = z;
        }

        public void a(a.InterfaceC0552a interfaceC0552a) {
            this.eif.put(interfaceC0552a, interfaceC0552a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.eie.get());
                }
                interfaceC0552a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.eic) {
                if (aVar == null) {
                    aVar = new a(this.eie.get());
                }
                interfaceC0552a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0552a interfaceC0552a) {
            this.eif.remove(interfaceC0552a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.eie.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.eie.get().getLastSurfaceTexture() == null) {
                this.eie.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.eic = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.eie.get());
            for (a.InterfaceC0552a interfaceC0552a : this.eif.keySet()) {
                interfaceC0552a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.eic = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.eie.get());
            for (a.InterfaceC0552a interfaceC0552a : this.eif.keySet()) {
                interfaceC0552a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.eic = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.eie.get());
            for (a.InterfaceC0552a interfaceC0552a : this.eif.keySet()) {
                interfaceC0552a.a(aVar);
            }
            return this.eid;
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
