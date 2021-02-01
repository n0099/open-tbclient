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
/* loaded from: classes15.dex */
public class TextureRenderView extends TextureView implements com.baidu.swan.videoplayer.a {
    private com.baidu.swan.videoplayer.b eAl;
    private int eAm;
    private SurfaceTexture eAn;
    public b eAo;

    public TextureRenderView(Context context) {
        super(context);
        this.eAm = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eAm = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eAm = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.eAl = new com.baidu.swan.videoplayer.b(this);
        this.eAo = new b(this);
        setSurfaceTextureListener(this.eAo);
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
            this.eAl.setVideoSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.eAl.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.eAl.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setAspectRatio(int i) {
        this.eAl.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.eAl.aC(i, i2);
        setMeasuredDimension(this.eAl.bfM(), this.eAl.bfN());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.eAm = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.eAm;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.eAn;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.eAn = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static final class a implements a.b {
        private TextureRenderView eAp;

        public a(TextureRenderView textureRenderView) {
            this.eAp = textureRenderView;
        }

        @Override // com.baidu.swan.videoplayer.a.b
        @TargetApi(16)
        public void b(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.eAp.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.eAp.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(openSurface());
                } else if (!this.eAp.getLastSurfaceTexture().equals(this.eAp.getSurfaceTexture())) {
                    this.eAp.setSurfaceTexture(this.eAp.getLastSurfaceTexture());
                }
                this.eAp.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b
        public com.baidu.swan.videoplayer.a bfL() {
            return this.eAp;
        }

        public Surface openSurface() {
            return new Surface(this.eAp.getSurfaceTexture());
        }
    }

    @Override // com.baidu.swan.videoplayer.a
    public void a(a.InterfaceC0545a interfaceC0545a) {
        this.eAo.a(interfaceC0545a);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void b(a.InterfaceC0545a interfaceC0545a) {
        this.eAo.b(interfaceC0545a);
    }

    @Override // com.baidu.swan.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.eAn != null) {
            if (isAvailable()) {
                this.eAo.iM(true);
                return;
            }
            this.eAn.release();
            this.eAn = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean eAq;
        private WeakReference<TextureRenderView> eAs;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean eAr = false;
        private Map<a.InterfaceC0545a, Object> eAt = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.eAs = new WeakReference<>(textureRenderView);
        }

        public void iM(boolean z) {
            this.eAr = z;
        }

        public void a(a.InterfaceC0545a interfaceC0545a) {
            this.eAt.put(interfaceC0545a, interfaceC0545a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.eAs.get());
                }
                interfaceC0545a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.eAq) {
                if (aVar == null) {
                    aVar = new a(this.eAs.get());
                }
                interfaceC0545a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0545a interfaceC0545a) {
            this.eAt.remove(interfaceC0545a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.eAs.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.eAs.get().getLastSurfaceTexture() == null) {
                this.eAs.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.eAq = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.eAs.get());
            for (a.InterfaceC0545a interfaceC0545a : this.eAt.keySet()) {
                interfaceC0545a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.eAq = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.eAs.get());
            for (a.InterfaceC0545a interfaceC0545a : this.eAt.keySet()) {
                interfaceC0545a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.eAq = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.eAs.get());
            for (a.InterfaceC0545a interfaceC0545a : this.eAt.keySet()) {
                interfaceC0545a.a(aVar);
            }
            return this.eAr;
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
