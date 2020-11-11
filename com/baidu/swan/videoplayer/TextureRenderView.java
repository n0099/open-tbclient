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
    private com.baidu.swan.videoplayer.b enQ;
    private int enR;
    private SurfaceTexture enS;
    public b enT;

    public TextureRenderView(Context context) {
        super(context);
        this.enR = 0;
        dQ(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.enR = 0;
        dQ(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.enR = 0;
        dQ(context);
    }

    private void dQ(Context context) {
        this.enQ = new com.baidu.swan.videoplayer.b(this);
        this.enT = new b(this);
        setSurfaceTextureListener(this.enT);
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
            this.enQ.setVideoSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.enQ.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.enQ.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setAspectRatio(int i) {
        this.enQ.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.enQ.aG(i, i2);
        setMeasuredDimension(this.enQ.bex(), this.enQ.bey());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.enR = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.enR;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.enS;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.enS = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class a implements a.b {
        private TextureRenderView enU;

        public a(TextureRenderView textureRenderView) {
            this.enU = textureRenderView;
        }

        @Override // com.baidu.swan.videoplayer.a.b
        @TargetApi(16)
        public void b(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.enU.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.enU.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(beF());
                } else if (!this.enU.getLastSurfaceTexture().equals(this.enU.getSurfaceTexture())) {
                    this.enU.setSurfaceTexture(this.enU.getLastSurfaceTexture());
                }
                this.enU.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b
        public com.baidu.swan.videoplayer.a bew() {
            return this.enU;
        }

        public Surface beF() {
            return new Surface(this.enU.getSurfaceTexture());
        }
    }

    @Override // com.baidu.swan.videoplayer.a
    public void a(a.InterfaceC0564a interfaceC0564a) {
        this.enT.a(interfaceC0564a);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void b(a.InterfaceC0564a interfaceC0564a) {
        this.enT.b(interfaceC0564a);
    }

    @Override // com.baidu.swan.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.enS != null) {
            if (isAvailable()) {
                this.enT.ib(true);
                return;
            }
            this.enS.release();
            this.enS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean enV;
        private WeakReference<TextureRenderView> enX;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean enW = false;
        private Map<a.InterfaceC0564a, Object> enY = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.enX = new WeakReference<>(textureRenderView);
        }

        public void ib(boolean z) {
            this.enW = z;
        }

        public void a(a.InterfaceC0564a interfaceC0564a) {
            this.enY.put(interfaceC0564a, interfaceC0564a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.enX.get());
                }
                interfaceC0564a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.enV) {
                if (aVar == null) {
                    aVar = new a(this.enX.get());
                }
                interfaceC0564a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0564a interfaceC0564a) {
            this.enY.remove(interfaceC0564a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.enX.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.enX.get().getLastSurfaceTexture() == null) {
                this.enX.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.enV = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.enX.get());
            for (a.InterfaceC0564a interfaceC0564a : this.enY.keySet()) {
                interfaceC0564a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.enV = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.enX.get());
            for (a.InterfaceC0564a interfaceC0564a : this.enY.keySet()) {
                interfaceC0564a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.enV = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.enX.get());
            for (a.InterfaceC0564a interfaceC0564a : this.enY.keySet()) {
                interfaceC0564a.a(aVar);
            }
            return this.enW;
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
