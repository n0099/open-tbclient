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
/* loaded from: classes11.dex */
public class TextureRenderView extends TextureView implements com.baidu.swan.videoplayer.a {
    private com.baidu.swan.videoplayer.b drE;
    private int drF;
    private SurfaceTexture drG;
    public b drH;

    public TextureRenderView(Context context) {
        super(context);
        this.drF = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drF = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drF = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.drE = new com.baidu.swan.videoplayer.b(this);
        this.drH = new b(this);
        setSurfaceTextureListener(this.drH);
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
            this.drE.setVideoSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.drE.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.drE.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setAspectRatio(int i) {
        this.drE.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.drE.ax(i, i2);
        setMeasuredDimension(this.drE.aJs(), this.drE.aJt());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.drF = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.drF;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.drG;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.drG = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static final class a implements a.b {
        private TextureRenderView drI;

        public a(TextureRenderView textureRenderView) {
            this.drI = textureRenderView;
        }

        @Override // com.baidu.swan.videoplayer.a.b
        @TargetApi(16)
        public void b(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.drI.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.drI.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(aJA());
                } else if (!this.drI.getLastSurfaceTexture().equals(this.drI.getSurfaceTexture())) {
                    this.drI.setSurfaceTexture(this.drI.getLastSurfaceTexture());
                }
                this.drI.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b
        public com.baidu.swan.videoplayer.a aJr() {
            return this.drI;
        }

        public Surface aJA() {
            return new Surface(this.drI.getSurfaceTexture());
        }
    }

    @Override // com.baidu.swan.videoplayer.a
    public void a(a.InterfaceC0462a interfaceC0462a) {
        this.drH.a(interfaceC0462a);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void b(a.InterfaceC0462a interfaceC0462a) {
        this.drH.b(interfaceC0462a);
    }

    @Override // com.baidu.swan.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.drG != null) {
            if (isAvailable()) {
                this.drH.gq(true);
                return;
            }
            this.drG.release();
            this.drG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean drJ;
        private WeakReference<TextureRenderView> drL;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean drK = false;
        private Map<a.InterfaceC0462a, Object> drM = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.drL = new WeakReference<>(textureRenderView);
        }

        public void gq(boolean z) {
            this.drK = z;
        }

        public void a(a.InterfaceC0462a interfaceC0462a) {
            this.drM.put(interfaceC0462a, interfaceC0462a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.drL.get());
                }
                interfaceC0462a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.drJ) {
                if (aVar == null) {
                    aVar = new a(this.drL.get());
                }
                interfaceC0462a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0462a interfaceC0462a) {
            this.drM.remove(interfaceC0462a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.drL.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.drL.get().getLastSurfaceTexture() == null) {
                this.drL.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.drJ = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.drL.get());
            for (a.InterfaceC0462a interfaceC0462a : this.drM.keySet()) {
                interfaceC0462a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.drJ = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.drL.get());
            for (a.InterfaceC0462a interfaceC0462a : this.drM.keySet()) {
                interfaceC0462a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.drJ = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.drL.get());
            for (a.InterfaceC0462a interfaceC0462a : this.drM.keySet()) {
                interfaceC0462a.a(aVar);
            }
            return this.drK;
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
