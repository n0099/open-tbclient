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
    private com.baidu.swan.videoplayer.b dLw;
    private int dLx;
    private SurfaceTexture dLy;
    public b dLz;

    public TextureRenderView(Context context) {
        super(context);
        this.dLx = 0;
        dL(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dLx = 0;
        dL(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dLx = 0;
        dL(context);
    }

    private void dL(Context context) {
        this.dLw = new com.baidu.swan.videoplayer.b(this);
        this.dLz = new b(this);
        setSurfaceTextureListener(this.dLz);
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
            this.dLw.setVideoSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.dLw.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.dLw.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setAspectRatio(int i) {
        this.dLw.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dLw.aG(i, i2);
        setMeasuredDimension(this.dLw.aWK(), this.dLw.aWL());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.dLx = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.dLx;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.dLy;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.dLy = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static final class a implements a.b {
        private TextureRenderView dLA;

        public a(TextureRenderView textureRenderView) {
            this.dLA = textureRenderView;
        }

        @Override // com.baidu.swan.videoplayer.a.b
        @TargetApi(16)
        public void b(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.dLA.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.dLA.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(aWS());
                } else if (!this.dLA.getLastSurfaceTexture().equals(this.dLA.getSurfaceTexture())) {
                    this.dLA.setSurfaceTexture(this.dLA.getLastSurfaceTexture());
                }
                this.dLA.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b
        public com.baidu.swan.videoplayer.a aWJ() {
            return this.dLA;
        }

        public Surface aWS() {
            return new Surface(this.dLA.getSurfaceTexture());
        }
    }

    @Override // com.baidu.swan.videoplayer.a
    public void a(a.InterfaceC0526a interfaceC0526a) {
        this.dLz.a(interfaceC0526a);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void b(a.InterfaceC0526a interfaceC0526a) {
        this.dLz.b(interfaceC0526a);
    }

    @Override // com.baidu.swan.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.dLy != null) {
            if (isAvailable()) {
                this.dLz.hl(true);
                return;
            }
            this.dLy.release();
            this.dLy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean dLB;
        private WeakReference<TextureRenderView> dLD;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean dLC = false;
        private Map<a.InterfaceC0526a, Object> dLE = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.dLD = new WeakReference<>(textureRenderView);
        }

        public void hl(boolean z) {
            this.dLC = z;
        }

        public void a(a.InterfaceC0526a interfaceC0526a) {
            this.dLE.put(interfaceC0526a, interfaceC0526a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.dLD.get());
                }
                interfaceC0526a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.dLB) {
                if (aVar == null) {
                    aVar = new a(this.dLD.get());
                }
                interfaceC0526a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0526a interfaceC0526a) {
            this.dLE.remove(interfaceC0526a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.dLD.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.dLD.get().getLastSurfaceTexture() == null) {
                this.dLD.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.dLB = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dLD.get());
            for (a.InterfaceC0526a interfaceC0526a : this.dLE.keySet()) {
                interfaceC0526a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.dLB = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.dLD.get());
            for (a.InterfaceC0526a interfaceC0526a : this.dLE.keySet()) {
                interfaceC0526a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.dLB = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dLD.get());
            for (a.InterfaceC0526a interfaceC0526a : this.dLE.keySet()) {
                interfaceC0526a.a(aVar);
            }
            return this.dLC;
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
