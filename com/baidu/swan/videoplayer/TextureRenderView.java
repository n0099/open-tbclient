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
    private com.baidu.swan.videoplayer.b eyc;
    private int eyd;
    private SurfaceTexture eyf;
    public b eyg;

    public TextureRenderView(Context context) {
        super(context);
        this.eyd = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eyd = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eyd = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.eyc = new com.baidu.swan.videoplayer.b(this);
        this.eyg = new b(this);
        setSurfaceTextureListener(this.eyg);
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
            this.eyc.setVideoSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.eyc.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.eyc.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setAspectRatio(int i) {
        this.eyc.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.eyc.aF(i, i2);
        setMeasuredDimension(this.eyc.bfz(), this.eyc.bfA());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.eyd = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.eyd;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.eyf;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.eyf = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static final class a implements a.b {
        private TextureRenderView eyh;

        public a(TextureRenderView textureRenderView) {
            this.eyh = textureRenderView;
        }

        @Override // com.baidu.swan.videoplayer.a.b
        @TargetApi(16)
        public void b(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.eyh.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.eyh.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(openSurface());
                } else if (!this.eyh.getLastSurfaceTexture().equals(this.eyh.getSurfaceTexture())) {
                    this.eyh.setSurfaceTexture(this.eyh.getLastSurfaceTexture());
                }
                this.eyh.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b
        public com.baidu.swan.videoplayer.a bfy() {
            return this.eyh;
        }

        public Surface openSurface() {
            return new Surface(this.eyh.getSurfaceTexture());
        }
    }

    @Override // com.baidu.swan.videoplayer.a
    public void a(a.InterfaceC0548a interfaceC0548a) {
        this.eyg.a(interfaceC0548a);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void b(a.InterfaceC0548a interfaceC0548a) {
        this.eyg.b(interfaceC0548a);
    }

    @Override // com.baidu.swan.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.eyf != null) {
            if (isAvailable()) {
                this.eyg.iK(true);
                return;
            }
            this.eyf.release();
            this.eyf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean eyi;
        private WeakReference<TextureRenderView> eyk;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean eyj = false;
        private Map<a.InterfaceC0548a, Object> eyl = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.eyk = new WeakReference<>(textureRenderView);
        }

        public void iK(boolean z) {
            this.eyj = z;
        }

        public void a(a.InterfaceC0548a interfaceC0548a) {
            this.eyl.put(interfaceC0548a, interfaceC0548a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.eyk.get());
                }
                interfaceC0548a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.eyi) {
                if (aVar == null) {
                    aVar = new a(this.eyk.get());
                }
                interfaceC0548a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0548a interfaceC0548a) {
            this.eyl.remove(interfaceC0548a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.eyk.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.eyk.get().getLastSurfaceTexture() == null) {
                this.eyk.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.eyi = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.eyk.get());
            for (a.InterfaceC0548a interfaceC0548a : this.eyl.keySet()) {
                interfaceC0548a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.eyi = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.eyk.get());
            for (a.InterfaceC0548a interfaceC0548a : this.eyl.keySet()) {
                interfaceC0548a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.eyi = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.eyk.get());
            for (a.InterfaceC0548a interfaceC0548a : this.eyl.keySet()) {
                interfaceC0548a.a(aVar);
            }
            return this.eyj;
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
