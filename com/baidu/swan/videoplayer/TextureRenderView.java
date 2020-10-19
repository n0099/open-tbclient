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
    private com.baidu.swan.videoplayer.b dZA;
    private int dZB;
    private SurfaceTexture dZC;
    public b dZD;

    public TextureRenderView(Context context) {
        super(context);
        this.dZB = 0;
        dQ(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dZB = 0;
        dQ(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dZB = 0;
        dQ(context);
    }

    private void dQ(Context context) {
        this.dZA = new com.baidu.swan.videoplayer.b(this);
        this.dZD = new b(this);
        setSurfaceTextureListener(this.dZD);
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
            this.dZA.setVideoSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.dZA.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.dZA.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setAspectRatio(int i) {
        this.dZA.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dZA.aF(i, i2);
        setMeasuredDimension(this.dZA.bae(), this.dZA.baf());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.dZB = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.dZB;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.dZC;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.dZC = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class a implements a.b {
        private TextureRenderView dZE;

        public a(TextureRenderView textureRenderView) {
            this.dZE = textureRenderView;
        }

        @Override // com.baidu.swan.videoplayer.a.b
        @TargetApi(16)
        public void b(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.dZE.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.dZE.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(bam());
                } else if (!this.dZE.getLastSurfaceTexture().equals(this.dZE.getSurfaceTexture())) {
                    this.dZE.setSurfaceTexture(this.dZE.getLastSurfaceTexture());
                }
                this.dZE.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b
        public com.baidu.swan.videoplayer.a bad() {
            return this.dZE;
        }

        public Surface bam() {
            return new Surface(this.dZE.getSurfaceTexture());
        }
    }

    @Override // com.baidu.swan.videoplayer.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.dZD.a(interfaceC0538a);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void b(a.InterfaceC0538a interfaceC0538a) {
        this.dZD.b(interfaceC0538a);
    }

    @Override // com.baidu.swan.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.dZC != null) {
            if (isAvailable()) {
                this.dZD.hF(true);
                return;
            }
            this.dZC.release();
            this.dZC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean dZF;
        private WeakReference<TextureRenderView> dZH;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean dZG = false;
        private Map<a.InterfaceC0538a, Object> dZI = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.dZH = new WeakReference<>(textureRenderView);
        }

        public void hF(boolean z) {
            this.dZG = z;
        }

        public void a(a.InterfaceC0538a interfaceC0538a) {
            this.dZI.put(interfaceC0538a, interfaceC0538a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.dZH.get());
                }
                interfaceC0538a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.dZF) {
                if (aVar == null) {
                    aVar = new a(this.dZH.get());
                }
                interfaceC0538a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0538a interfaceC0538a) {
            this.dZI.remove(interfaceC0538a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.dZH.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.dZH.get().getLastSurfaceTexture() == null) {
                this.dZH.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.dZF = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dZH.get());
            for (a.InterfaceC0538a interfaceC0538a : this.dZI.keySet()) {
                interfaceC0538a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.dZF = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.dZH.get());
            for (a.InterfaceC0538a interfaceC0538a : this.dZI.keySet()) {
                interfaceC0538a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.dZF = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dZH.get());
            for (a.InterfaceC0538a interfaceC0538a : this.dZI.keySet()) {
                interfaceC0538a.a(aVar);
            }
            return this.dZG;
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
