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
/* loaded from: classes3.dex */
public class TextureRenderView extends TextureView implements com.baidu.swan.videoplayer.a {
    private com.baidu.swan.videoplayer.b eCQ;
    private int eCR;
    private SurfaceTexture eCS;
    public b eCT;

    public TextureRenderView(Context context) {
        super(context);
        this.eCR = 0;
        eO(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eCR = 0;
        eO(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eCR = 0;
        eO(context);
    }

    private void eO(Context context) {
        this.eCQ = new com.baidu.swan.videoplayer.b(this);
        this.eCT = new b(this);
        setSurfaceTextureListener(this.eCT);
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
            this.eCQ.setVideoSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.eCQ.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.eCQ.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setAspectRatio(int i) {
        this.eCQ.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.eCQ.aF(i, i2);
        setMeasuredDimension(this.eCQ.bjs(), this.eCQ.bjt());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.eCR = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.eCR;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.eCS;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.eCS = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a implements a.b {
        private TextureRenderView eCU;

        public a(TextureRenderView textureRenderView) {
            this.eCU = textureRenderView;
        }

        @Override // com.baidu.swan.videoplayer.a.b
        @TargetApi(16)
        public void b(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.eCU.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.eCU.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(openSurface());
                } else if (!this.eCU.getLastSurfaceTexture().equals(this.eCU.getSurfaceTexture())) {
                    this.eCU.setSurfaceTexture(this.eCU.getLastSurfaceTexture());
                }
                this.eCU.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b
        public com.baidu.swan.videoplayer.a bjr() {
            return this.eCU;
        }

        public Surface openSurface() {
            return new Surface(this.eCU.getSurfaceTexture());
        }
    }

    @Override // com.baidu.swan.videoplayer.a
    public void a(a.InterfaceC0565a interfaceC0565a) {
        this.eCT.a(interfaceC0565a);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void b(a.InterfaceC0565a interfaceC0565a) {
        this.eCT.b(interfaceC0565a);
    }

    @Override // com.baidu.swan.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.eCS != null) {
            if (isAvailable()) {
                this.eCT.iO(true);
                return;
            }
            this.eCS.release();
            this.eCS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean eCV;
        private WeakReference<TextureRenderView> eCX;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean eCW = false;
        private Map<a.InterfaceC0565a, Object> eCY = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.eCX = new WeakReference<>(textureRenderView);
        }

        public void iO(boolean z) {
            this.eCW = z;
        }

        public void a(a.InterfaceC0565a interfaceC0565a) {
            this.eCY.put(interfaceC0565a, interfaceC0565a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.eCX.get());
                }
                interfaceC0565a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.eCV) {
                if (aVar == null) {
                    aVar = new a(this.eCX.get());
                }
                interfaceC0565a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0565a interfaceC0565a) {
            this.eCY.remove(interfaceC0565a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.eCX.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.eCX.get().getLastSurfaceTexture() == null) {
                this.eCX.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.eCV = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.eCX.get());
            for (a.InterfaceC0565a interfaceC0565a : this.eCY.keySet()) {
                interfaceC0565a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.eCV = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.eCX.get());
            for (a.InterfaceC0565a interfaceC0565a : this.eCY.keySet()) {
                interfaceC0565a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.eCV = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.eCX.get());
            for (a.InterfaceC0565a interfaceC0565a : this.eCY.keySet()) {
                interfaceC0565a.a(aVar);
            }
            return this.eCW;
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
