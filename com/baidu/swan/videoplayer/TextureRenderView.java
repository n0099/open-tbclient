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
/* loaded from: classes14.dex */
public class TextureRenderView extends TextureView implements com.baidu.swan.videoplayer.a {
    private com.baidu.swan.videoplayer.b eBM;
    private int eBN;
    private SurfaceTexture eBO;
    public b eBP;

    public TextureRenderView(Context context) {
        super(context);
        this.eBN = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eBN = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eBN = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.eBM = new com.baidu.swan.videoplayer.b(this);
        this.eBP = new b(this);
        setSurfaceTextureListener(this.eBP);
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
            this.eBM.setVideoSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.eBM.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.eBM.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setAspectRatio(int i) {
        this.eBM.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.eBM.aC(i, i2);
        setMeasuredDimension(this.eBM.bfO(), this.eBM.bfP());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.eBN = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.eBN;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.eBO;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.eBO = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static final class a implements a.b {
        private TextureRenderView eBQ;

        public a(TextureRenderView textureRenderView) {
            this.eBQ = textureRenderView;
        }

        @Override // com.baidu.swan.videoplayer.a.b
        @TargetApi(16)
        public void b(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.eBQ.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.eBQ.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(openSurface());
                } else if (!this.eBQ.getLastSurfaceTexture().equals(this.eBQ.getSurfaceTexture())) {
                    this.eBQ.setSurfaceTexture(this.eBQ.getLastSurfaceTexture());
                }
                this.eBQ.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b
        public com.baidu.swan.videoplayer.a bfN() {
            return this.eBQ;
        }

        public Surface openSurface() {
            return new Surface(this.eBQ.getSurfaceTexture());
        }
    }

    @Override // com.baidu.swan.videoplayer.a
    public void a(a.InterfaceC0551a interfaceC0551a) {
        this.eBP.a(interfaceC0551a);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void b(a.InterfaceC0551a interfaceC0551a) {
        this.eBP.b(interfaceC0551a);
    }

    @Override // com.baidu.swan.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.eBO != null) {
            if (isAvailable()) {
                this.eBP.iM(true);
                return;
            }
            this.eBO.release();
            this.eBO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean eBR;
        private WeakReference<TextureRenderView> eBT;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean eBS = false;
        private Map<a.InterfaceC0551a, Object> eBU = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.eBT = new WeakReference<>(textureRenderView);
        }

        public void iM(boolean z) {
            this.eBS = z;
        }

        public void a(a.InterfaceC0551a interfaceC0551a) {
            this.eBU.put(interfaceC0551a, interfaceC0551a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.eBT.get());
                }
                interfaceC0551a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.eBR) {
                if (aVar == null) {
                    aVar = new a(this.eBT.get());
                }
                interfaceC0551a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0551a interfaceC0551a) {
            this.eBU.remove(interfaceC0551a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.eBT.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.eBT.get().getLastSurfaceTexture() == null) {
                this.eBT.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.eBR = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.eBT.get());
            for (a.InterfaceC0551a interfaceC0551a : this.eBU.keySet()) {
                interfaceC0551a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.eBR = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.eBT.get());
            for (a.InterfaceC0551a interfaceC0551a : this.eBU.keySet()) {
                interfaceC0551a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.eBR = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.eBT.get());
            for (a.InterfaceC0551a interfaceC0551a : this.eBU.keySet()) {
                interfaceC0551a.a(aVar);
            }
            return this.eBS;
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
