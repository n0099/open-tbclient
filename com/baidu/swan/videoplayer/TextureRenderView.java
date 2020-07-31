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
    private com.baidu.swan.videoplayer.b dCh;
    private int dCi;
    private SurfaceTexture dCj;
    public b dCk;

    public TextureRenderView(Context context) {
        super(context);
        this.dCi = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dCi = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dCi = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.dCh = new com.baidu.swan.videoplayer.b(this);
        this.dCk = new b(this);
        setSurfaceTextureListener(this.dCk);
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
            this.dCh.setVideoSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.dCh.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.dCh.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setAspectRatio(int i) {
        this.dCh.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dCh.az(i, i2);
        setMeasuredDimension(this.dCh.aOm(), this.dCh.aOn());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.dCi = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.dCi;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.dCj;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.dCj = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a implements a.b {
        private TextureRenderView dCl;

        public a(TextureRenderView textureRenderView) {
            this.dCl = textureRenderView;
        }

        @Override // com.baidu.swan.videoplayer.a.b
        @TargetApi(16)
        public void b(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.dCl.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.dCl.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(aOu());
                } else if (!this.dCl.getLastSurfaceTexture().equals(this.dCl.getSurfaceTexture())) {
                    this.dCl.setSurfaceTexture(this.dCl.getLastSurfaceTexture());
                }
                this.dCl.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b
        public com.baidu.swan.videoplayer.a aOl() {
            return this.dCl;
        }

        public Surface aOu() {
            return new Surface(this.dCl.getSurfaceTexture());
        }
    }

    @Override // com.baidu.swan.videoplayer.a
    public void a(a.InterfaceC0480a interfaceC0480a) {
        this.dCk.a(interfaceC0480a);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void b(a.InterfaceC0480a interfaceC0480a) {
        this.dCk.b(interfaceC0480a);
    }

    @Override // com.baidu.swan.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.dCj != null) {
            if (isAvailable()) {
                this.dCk.gQ(true);
                return;
            }
            this.dCj.release();
            this.dCj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean dCm;
        private WeakReference<TextureRenderView> dCo;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean dCn = false;
        private Map<a.InterfaceC0480a, Object> dCp = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.dCo = new WeakReference<>(textureRenderView);
        }

        public void gQ(boolean z) {
            this.dCn = z;
        }

        public void a(a.InterfaceC0480a interfaceC0480a) {
            this.dCp.put(interfaceC0480a, interfaceC0480a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.dCo.get());
                }
                interfaceC0480a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.dCm) {
                if (aVar == null) {
                    aVar = new a(this.dCo.get());
                }
                interfaceC0480a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0480a interfaceC0480a) {
            this.dCp.remove(interfaceC0480a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.dCo.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.dCo.get().getLastSurfaceTexture() == null) {
                this.dCo.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.dCm = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dCo.get());
            for (a.InterfaceC0480a interfaceC0480a : this.dCp.keySet()) {
                interfaceC0480a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.dCm = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.dCo.get());
            for (a.InterfaceC0480a interfaceC0480a : this.dCp.keySet()) {
                interfaceC0480a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.dCm = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dCo.get());
            for (a.InterfaceC0480a interfaceC0480a : this.dCp.keySet()) {
                interfaceC0480a.a(aVar);
            }
            return this.dCn;
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
