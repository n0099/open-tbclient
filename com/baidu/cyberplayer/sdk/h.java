package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.baidu.cyberplayer.sdk.i;
/* loaded from: classes12.dex */
public class h extends TextureView implements i {

    /* renamed from: a  reason: collision with root package name */
    private a f1387a;
    private SurfaceTexture b;
    private Surface c;
    private i.a d;
    private f e;
    private boolean f;

    /* loaded from: classes12.dex */
    private class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            CyberLog.d("CyberTextureView", "onSurfaceTextureAvailable surface:" + surfaceTexture + " width:" + i + " height:" + i2);
            if (h.this.b == null) {
                h.this.b = surfaceTexture;
                if (h.this.d != null) {
                    h.this.d.a(1);
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                h.this.setSurfaceTexture(h.this.b);
            } else {
                h.this.b = surfaceTexture;
                if (h.this.d != null) {
                    h.this.d.a(1);
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            CyberLog.d("CyberTextureView", "onSurfaceTextureDestroyed surface:" + surfaceTexture);
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            CyberLog.d("CyberTextureView", "onSurfaceTextureSizeChanged surface:" + surfaceTexture + " width:" + i + " height:" + i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (h.this.f) {
                return;
            }
            h.this.f = true;
            if (h.this.d != null) {
                h.this.d.a(System.currentTimeMillis());
            }
        }
    }

    public h(Context context) {
        super(context);
        this.f1387a = new a();
        setSurfaceTextureListener(this.f1387a);
        this.e = new f();
        this.f = false;
    }

    private void a(int i) {
        int d = this.e.d();
        if (d > 0) {
            d = 360 - d;
        }
        CyberLog.i("CyberTextureView", "updateRotation rotate:" + i + " drawFrameRotation:" + d);
        setRotation(d);
        requestLayout();
    }

    private void f() {
        requestLayout();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Bitmap a(float f, int i, int i2) {
        return getBitmap();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a() {
        CyberLog.d("CyberTextureView", "release called mSurfaceTexture:" + this.b);
        if (this.c != null) {
            this.c.release();
            this.c = null;
        }
        this.b = null;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a(int i, int i2, int i3, int i4) {
        if (this.e.a(i, i2, i3, i4)) {
            f();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void b() {
        if (this.b != null) {
            this.b.release();
            this.b = null;
        }
        a();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void c() {
        setRotation(0.0f);
        this.e.a();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Surface d() {
        CyberLog.d("CyberTextureView", "createNewSurface mSurface:" + this.c);
        if (this.c != null) {
            this.c.release();
            this.c = null;
        }
        CyberLog.d("CyberTextureView", "createNewSurface getSurfaceTexture:" + getSurfaceTexture());
        if (getSurfaceTexture() != null) {
            this.c = new Surface(getSurfaceTexture());
            this.b = getSurfaceTexture();
            this.f = false;
        }
        CyberLog.d("CyberTextureView", "createNewSurface mSurface:" + this.c);
        return this.c;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public boolean e() {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public View getView() {
        return this;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        this.e.a(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.e.b();
        boolean z = this.e.d() == 90 || this.e.d() == 270;
        if (!z) {
            i2 = i;
            i = i2;
        }
        int defaultSize = View.getDefaultSize(this.e.e(), i2);
        int defaultSize2 = View.getDefaultSize(this.e.f(), i);
        float[] c = this.e.c();
        if (z) {
            i3 = (int) (c[1] * defaultSize);
            i4 = (int) (c[0] * defaultSize2);
        } else {
            i3 = (int) (c[0] * defaultSize);
            i4 = (int) (c[1] * defaultSize2);
        }
        setMeasuredDimension(i3, i4);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setClientRotation(int i) {
        if (this.e.b(i)) {
            a(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setCyberSurfaceListener(i.a aVar) {
        this.d = aVar;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setDisplayMode(int i) {
        if (this.e.c(i)) {
            f();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setRawFrameRotation(int i) {
        if (this.e.a(i)) {
            a(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setZOrderMediaOverlay(boolean z) {
    }
}
