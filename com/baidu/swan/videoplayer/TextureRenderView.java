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
/* loaded from: classes6.dex */
public class TextureRenderView extends TextureView implements com.baidu.swan.videoplayer.a {
    private com.baidu.swan.videoplayer.b etj;
    private int etk;
    private SurfaceTexture etl;
    public b etm;

    public TextureRenderView(Context context) {
        super(context);
        this.etk = 0;
        ev(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.etk = 0;
        ev(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.etk = 0;
        ev(context);
    }

    private void ev(Context context) {
        this.etj = new com.baidu.swan.videoplayer.b(this);
        this.etm = new b(this);
        setSurfaceTextureListener(this.etm);
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
            this.etj.setVideoSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.etj.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.etj.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setAspectRatio(int i) {
        this.etj.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.etj.aI(i, i2);
        setMeasuredDimension(this.etj.bgV(), this.etj.bgW());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.etk = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.etk;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.etl;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.etl = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a implements a.b {
        private TextureRenderView etn;

        public a(TextureRenderView textureRenderView) {
            this.etn = textureRenderView;
        }

        @Override // com.baidu.swan.videoplayer.a.b
        @TargetApi(16)
        public void b(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.etn.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.etn.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(bhd());
                } else if (!this.etn.getLastSurfaceTexture().equals(this.etn.getSurfaceTexture())) {
                    this.etn.setSurfaceTexture(this.etn.getLastSurfaceTexture());
                }
                this.etn.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b
        public com.baidu.swan.videoplayer.a bgU() {
            return this.etn;
        }

        public Surface bhd() {
            return new Surface(this.etn.getSurfaceTexture());
        }
    }

    @Override // com.baidu.swan.videoplayer.a
    public void a(a.InterfaceC0574a interfaceC0574a) {
        this.etm.a(interfaceC0574a);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void b(a.InterfaceC0574a interfaceC0574a) {
        this.etm.b(interfaceC0574a);
    }

    @Override // com.baidu.swan.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.etl != null) {
            if (isAvailable()) {
                this.etm.it(true);
                return;
            }
            this.etl.release();
            this.etl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean eto;
        private WeakReference<TextureRenderView> etq;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean etp = false;
        private Map<a.InterfaceC0574a, Object> etr = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.etq = new WeakReference<>(textureRenderView);
        }

        public void it(boolean z) {
            this.etp = z;
        }

        public void a(a.InterfaceC0574a interfaceC0574a) {
            this.etr.put(interfaceC0574a, interfaceC0574a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.etq.get());
                }
                interfaceC0574a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.eto) {
                if (aVar == null) {
                    aVar = new a(this.etq.get());
                }
                interfaceC0574a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0574a interfaceC0574a) {
            this.etr.remove(interfaceC0574a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.etq.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.etq.get().getLastSurfaceTexture() == null) {
                this.etq.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.eto = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.etq.get());
            for (a.InterfaceC0574a interfaceC0574a : this.etr.keySet()) {
                interfaceC0574a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.eto = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.etq.get());
            for (a.InterfaceC0574a interfaceC0574a : this.etr.keySet()) {
                interfaceC0574a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.eto = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.etq.get());
            for (a.InterfaceC0574a interfaceC0574a : this.etr.keySet()) {
                interfaceC0574a.a(aVar);
            }
            return this.etp;
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
