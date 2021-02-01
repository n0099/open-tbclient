package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.i;
/* loaded from: classes4.dex */
public class h extends TextureView implements i {

    /* renamed from: a  reason: collision with root package name */
    private a f1771a;

    /* renamed from: b  reason: collision with root package name */
    private SurfaceTexture f1772b;
    private Surface c;
    private i.a d;
    private f e;
    private boolean f;
    private boolean g;
    private boolean h;

    /* loaded from: classes4.dex */
    private class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            CyberLog.d("CyberTextureView", "onSurfaceTextureAvailable surface:" + surfaceTexture + " width:" + i + " height:" + i2);
            if (h.this.f1772b == null) {
                h.this.f1772b = surfaceTexture;
                if (h.this.d != null) {
                    h.this.d.a(1);
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                h.this.setSurfaceTexture(h.this.f1772b);
            } else {
                h.this.f1772b = surfaceTexture;
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
        this.h = false;
        this.f1771a = new a();
        setSurfaceTextureListener(this.f1771a);
        this.e = new f();
        this.f = false;
        this.g = CyberCfgManager.getInstance().a("textureview_enable_translate", true);
    }

    private void a(int i) {
        int g = this.e.g();
        if (g > 0) {
            g = 360 - g;
        }
        CyberLog.i("CyberTextureView", "updateRotation rotate:" + i + " drawFrameRotation:" + g);
        setRotation(g);
        requestLayout();
    }

    private void b(int i, int i2, int i3, int i4) {
        if (this.g) {
            if (!this.e.f()) {
                if (this.h) {
                    Matrix matrix = new Matrix();
                    getTransform(matrix);
                    matrix.setTranslate(0.0f, 0.0f);
                    setTransform(matrix);
                    this.h = false;
                    return;
                }
                return;
            }
            Matrix matrix2 = new Matrix();
            getTransform(matrix2);
            CyberLog.i("CyberTextureView", "doTranslate old_width:" + i + " old_height:" + i2 + " width:" + i3 + " height:" + i4);
            float f = (i3 - i) / 2.0f;
            float f2 = (i4 - i2) / 2.0f;
            CyberLog.i("CyberTextureView", "doTranslate x:" + f + " y:" + f2);
            int d = this.e.d();
            if (d == 7) {
                matrix2.setTranslate(-f, 0.0f);
            } else if (d == 8) {
                matrix2.setTranslate(f, 0.0f);
            } else if (d == 9) {
                matrix2.setTranslate(0.0f, -f2);
            } else if (d == 10) {
                matrix2.setTranslate(0.0f, f2);
            }
            setTransform(matrix2);
            this.h = true;
        }
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
        CyberLog.d("CyberTextureView", "release called mSurfaceTexture:" + this.f1772b);
        if (this.c != null) {
            this.c.release();
            this.c = null;
        }
        this.f1772b = null;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a(int i, int i2, int i3, int i4) {
        if (this.e.a(i, i2, i3, i4)) {
            f();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void b() {
        if (this.f1772b != null) {
            this.f1772b.release();
            this.f1772b = null;
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
            this.f1772b = getSurfaceTexture();
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
        int i5;
        int i6;
        this.e.a(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.e.b();
        boolean z = this.e.g() == 90 || this.e.g() == 270;
        if (z) {
            i3 = i;
            i4 = i2;
        } else {
            i3 = i2;
            i4 = i;
        }
        int defaultSize = View.getDefaultSize(this.e.h(), i4);
        int defaultSize2 = View.getDefaultSize(this.e.i(), i3);
        float[] c = this.e.c();
        if (z) {
            i5 = (int) (c[1] * defaultSize);
            i6 = (int) (c[0] * defaultSize2);
        } else {
            i5 = (int) (c[0] * defaultSize);
            i6 = (int) (c[1] * defaultSize2);
        }
        setMeasuredDimension(i5, i6);
        b(defaultSize, defaultSize2, i5, i6);
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
