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
    private com.baidu.swan.videoplayer.b emh;
    private int emi;
    private SurfaceTexture emj;
    public b emk;

    public TextureRenderView(Context context) {
        super(context);
        this.emi = 0;
        dQ(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.emi = 0;
        dQ(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.emi = 0;
        dQ(context);
    }

    private void dQ(Context context) {
        this.emh = new com.baidu.swan.videoplayer.b(this);
        this.emk = new b(this);
        setSurfaceTextureListener(this.emk);
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
            this.emh.setVideoSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.emh.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.emh.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setAspectRatio(int i) {
        this.emh.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.emh.aG(i, i2);
        setMeasuredDimension(this.emh.bdQ(), this.emh.bdR());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.emi = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.emi;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.emj;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.emj = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a implements a.b {
        private TextureRenderView eml;

        public a(TextureRenderView textureRenderView) {
            this.eml = textureRenderView;
        }

        @Override // com.baidu.swan.videoplayer.a.b
        @TargetApi(16)
        public void b(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.eml.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.eml.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(bdY());
                } else if (!this.eml.getLastSurfaceTexture().equals(this.eml.getSurfaceTexture())) {
                    this.eml.setSurfaceTexture(this.eml.getLastSurfaceTexture());
                }
                this.eml.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b
        public com.baidu.swan.videoplayer.a bdP() {
            return this.eml;
        }

        public Surface bdY() {
            return new Surface(this.eml.getSurfaceTexture());
        }
    }

    @Override // com.baidu.swan.videoplayer.a
    public void a(a.InterfaceC0562a interfaceC0562a) {
        this.emk.a(interfaceC0562a);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void b(a.InterfaceC0562a interfaceC0562a) {
        this.emk.b(interfaceC0562a);
    }

    @Override // com.baidu.swan.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.emj != null) {
            if (isAvailable()) {
                this.emk.ie(true);
                return;
            }
            this.emj.release();
            this.emj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean emm;
        private WeakReference<TextureRenderView> emo;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean emn = false;
        private Map<a.InterfaceC0562a, Object> emp = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.emo = new WeakReference<>(textureRenderView);
        }

        public void ie(boolean z) {
            this.emn = z;
        }

        public void a(a.InterfaceC0562a interfaceC0562a) {
            this.emp.put(interfaceC0562a, interfaceC0562a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.emo.get());
                }
                interfaceC0562a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.emm) {
                if (aVar == null) {
                    aVar = new a(this.emo.get());
                }
                interfaceC0562a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0562a interfaceC0562a) {
            this.emp.remove(interfaceC0562a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.emo.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.emo.get().getLastSurfaceTexture() == null) {
                this.emo.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.emm = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.emo.get());
            for (a.InterfaceC0562a interfaceC0562a : this.emp.keySet()) {
                interfaceC0562a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.emm = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.emo.get());
            for (a.InterfaceC0562a interfaceC0562a : this.emp.keySet()) {
                interfaceC0562a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.emm = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.emo.get());
            for (a.InterfaceC0562a interfaceC0562a : this.emp.keySet()) {
                interfaceC0562a.a(aVar);
            }
            return this.emn;
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
