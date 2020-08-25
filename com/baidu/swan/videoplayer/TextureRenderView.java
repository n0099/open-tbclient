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
/* loaded from: classes9.dex */
public class TextureRenderView extends TextureView implements com.baidu.swan.videoplayer.a {
    private com.baidu.swan.videoplayer.b dLs;
    private int dLt;
    private SurfaceTexture dLu;
    public b dLv;

    public TextureRenderView(Context context) {
        super(context);
        this.dLt = 0;
        dL(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dLt = 0;
        dL(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dLt = 0;
        dL(context);
    }

    private void dL(Context context) {
        this.dLs = new com.baidu.swan.videoplayer.b(this);
        this.dLv = new b(this);
        setSurfaceTextureListener(this.dLv);
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
            this.dLs.setVideoSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.dLs.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.dLs.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setAspectRatio(int i) {
        this.dLs.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dLs.aG(i, i2);
        setMeasuredDimension(this.dLs.aWK(), this.dLs.aWL());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.dLt = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.dLt;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.dLu;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.dLu = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static final class a implements a.b {
        private TextureRenderView dLw;

        public a(TextureRenderView textureRenderView) {
            this.dLw = textureRenderView;
        }

        @Override // com.baidu.swan.videoplayer.a.b
        @TargetApi(16)
        public void b(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.dLw.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.dLw.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(aWS());
                } else if (!this.dLw.getLastSurfaceTexture().equals(this.dLw.getSurfaceTexture())) {
                    this.dLw.setSurfaceTexture(this.dLw.getLastSurfaceTexture());
                }
                this.dLw.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b
        public com.baidu.swan.videoplayer.a aWJ() {
            return this.dLw;
        }

        public Surface aWS() {
            return new Surface(this.dLw.getSurfaceTexture());
        }
    }

    @Override // com.baidu.swan.videoplayer.a
    public void a(a.InterfaceC0526a interfaceC0526a) {
        this.dLv.a(interfaceC0526a);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void b(a.InterfaceC0526a interfaceC0526a) {
        this.dLv.b(interfaceC0526a);
    }

    @Override // com.baidu.swan.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.dLu != null) {
            if (isAvailable()) {
                this.dLv.hk(true);
                return;
            }
            this.dLu.release();
            this.dLu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean dLx;
        private WeakReference<TextureRenderView> dLz;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean dLy = false;
        private Map<a.InterfaceC0526a, Object> dLA = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.dLz = new WeakReference<>(textureRenderView);
        }

        public void hk(boolean z) {
            this.dLy = z;
        }

        public void a(a.InterfaceC0526a interfaceC0526a) {
            this.dLA.put(interfaceC0526a, interfaceC0526a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.dLz.get());
                }
                interfaceC0526a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.dLx) {
                if (aVar == null) {
                    aVar = new a(this.dLz.get());
                }
                interfaceC0526a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0526a interfaceC0526a) {
            this.dLA.remove(interfaceC0526a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.dLz.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.dLz.get().getLastSurfaceTexture() == null) {
                this.dLz.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.dLx = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dLz.get());
            for (a.InterfaceC0526a interfaceC0526a : this.dLA.keySet()) {
                interfaceC0526a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.dLx = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.dLz.get());
            for (a.InterfaceC0526a interfaceC0526a : this.dLA.keySet()) {
                interfaceC0526a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.dLx = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dLz.get());
            for (a.InterfaceC0526a interfaceC0526a : this.dLA.keySet()) {
                interfaceC0526a.a(aVar);
            }
            return this.dLy;
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
