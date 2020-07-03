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
    private com.baidu.swan.videoplayer.b dwp;
    private int dwq;
    private SurfaceTexture dwr;
    public b dws;

    public TextureRenderView(Context context) {
        super(context);
        this.dwq = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dwq = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dwq = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.dwp = new com.baidu.swan.videoplayer.b(this);
        this.dws = new b(this);
        setSurfaceTextureListener(this.dws);
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
            this.dwp.setVideoSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.dwp.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.dwp.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void setAspectRatio(int i) {
        this.dwp.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dwp.az(i, i2);
        setMeasuredDimension(this.dwp.aKy(), this.dwp.aKz());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.dwq = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.dwq;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.dwr;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.dwr = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static final class a implements a.b {
        private TextureRenderView dwt;

        public a(TextureRenderView textureRenderView) {
            this.dwt = textureRenderView;
        }

        @Override // com.baidu.swan.videoplayer.a.b
        @TargetApi(16)
        public void b(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null && this.dwt.getSurfaceTexture() != null) {
                if (mediaPlayer.hashCode() != this.dwt.getCurrentMediaPlayerCode()) {
                    mediaPlayer.setSurface(aKG());
                } else if (!this.dwt.getLastSurfaceTexture().equals(this.dwt.getSurfaceTexture())) {
                    this.dwt.setSurfaceTexture(this.dwt.getLastSurfaceTexture());
                }
                this.dwt.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
            }
        }

        @Override // com.baidu.swan.videoplayer.a.b
        public com.baidu.swan.videoplayer.a aKx() {
            return this.dwt;
        }

        public Surface aKG() {
            return new Surface(this.dwt.getSurfaceTexture());
        }
    }

    @Override // com.baidu.swan.videoplayer.a
    public void a(a.InterfaceC0468a interfaceC0468a) {
        this.dws.a(interfaceC0468a);
    }

    @Override // com.baidu.swan.videoplayer.a
    public void b(a.InterfaceC0468a interfaceC0468a) {
        this.dws.b(interfaceC0468a);
    }

    @Override // com.baidu.swan.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.dwr != null) {
            if (isAvailable()) {
                this.dws.gv(true);
                return;
            }
            this.dwr.release();
            this.dwr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean dwu;
        private WeakReference<TextureRenderView> dww;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean dwv = false;
        private Map<a.InterfaceC0468a, Object> dwx = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.dww = new WeakReference<>(textureRenderView);
        }

        public void gv(boolean z) {
            this.dwv = z;
        }

        public void a(a.InterfaceC0468a interfaceC0468a) {
            this.dwx.put(interfaceC0468a, interfaceC0468a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.dww.get());
                }
                interfaceC0468a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.dwu) {
                if (aVar == null) {
                    aVar = new a(this.dww.get());
                }
                interfaceC0468a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0468a interfaceC0468a) {
            this.dwx.remove(interfaceC0468a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.dww.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.dww.get().getLastSurfaceTexture() == null) {
                this.dww.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.dwu = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dww.get());
            for (a.InterfaceC0468a interfaceC0468a : this.dwx.keySet()) {
                interfaceC0468a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.dwu = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.dww.get());
            for (a.InterfaceC0468a interfaceC0468a : this.dwx.keySet()) {
                interfaceC0468a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.dwu = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dww.get());
            for (a.InterfaceC0468a interfaceC0468a : this.dwx.keySet()) {
                interfaceC0468a.a(aVar);
            }
            return this.dwv;
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
