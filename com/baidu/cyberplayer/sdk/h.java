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
/* loaded from: classes2.dex */
public class h extends TextureView implements i {

    /* renamed from: a  reason: collision with root package name */
    public a f4960a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceTexture f4961b;

    /* renamed from: c  reason: collision with root package name */
    public Surface f4962c;

    /* renamed from: d  reason: collision with root package name */
    public i.a f4963d;

    /* renamed from: e  reason: collision with root package name */
    public f f4964e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4965f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4966g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4967h;

    /* loaded from: classes2.dex */
    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            CyberLog.d("CyberTextureView", "onSurfaceTextureAvailable surface:" + surfaceTexture + " width:" + i2 + " height:" + i3);
            if (h.this.f4961b == null) {
                h.this.f4961b = surfaceTexture;
                if (h.this.f4963d == null) {
                    return;
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                h hVar = h.this;
                hVar.setSurfaceTexture(hVar.f4961b);
                return;
            } else {
                h.this.f4961b = surfaceTexture;
                if (h.this.f4963d == null) {
                    return;
                }
            }
            h.this.f4963d.a(1);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            CyberLog.d("CyberTextureView", "onSurfaceTextureDestroyed surface:" + surfaceTexture);
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            CyberLog.d("CyberTextureView", "onSurfaceTextureSizeChanged surface:" + surfaceTexture + " width:" + i2 + " height:" + i3);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (h.this.f4965f) {
                return;
            }
            h.this.f4965f = true;
            if (h.this.f4963d != null) {
                h.this.f4963d.a(System.currentTimeMillis());
            }
        }
    }

    public h(Context context) {
        super(context);
        this.f4967h = false;
        a aVar = new a();
        this.f4960a = aVar;
        setSurfaceTextureListener(aVar);
        this.f4964e = new f();
        this.f4965f = false;
        this.f4966g = CyberCfgManager.getInstance().a("textureview_enable_translate", true);
    }

    private void a(int i2) {
        int g2 = this.f4964e.g();
        if (g2 > 0) {
            g2 = 360 - g2;
        }
        CyberLog.i("CyberTextureView", "updateRotation rotate:" + i2 + " drawFrameRotation:" + g2);
        setRotation((float) g2);
        requestLayout();
    }

    private void b(int i2, int i3, int i4, int i5) {
        boolean z;
        if (this.f4966g) {
            if (this.f4964e.f()) {
                Matrix matrix = new Matrix();
                getTransform(matrix);
                CyberLog.i("CyberTextureView", "doTranslate old_width:" + i2 + " old_height:" + i3 + " width:" + i4 + " height:" + i5);
                float f2 = ((float) (i4 - i2)) / 2.0f;
                float f3 = ((float) (i5 - i3)) / 2.0f;
                StringBuilder sb = new StringBuilder();
                sb.append("doTranslate x:");
                sb.append(f2);
                sb.append(" y:");
                sb.append(f3);
                CyberLog.i("CyberTextureView", sb.toString());
                int d2 = this.f4964e.d();
                if (d2 == 7) {
                    f2 = -f2;
                } else if (d2 != 8) {
                    if (d2 == 9) {
                        matrix.setTranslate(0.0f, -f3);
                    } else if (d2 == 10) {
                        matrix.setTranslate(0.0f, f3);
                    }
                    setTransform(matrix);
                    z = true;
                }
                matrix.setTranslate(f2, 0.0f);
                setTransform(matrix);
                z = true;
            } else if (!this.f4967h) {
                return;
            } else {
                Matrix matrix2 = new Matrix();
                getTransform(matrix2);
                matrix2.setTranslate(0.0f, 0.0f);
                setTransform(matrix2);
                z = false;
            }
            this.f4967h = z;
        }
    }

    private void f() {
        requestLayout();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Bitmap a(float f2, int i2, int i3) {
        return getBitmap();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a() {
        CyberLog.d("CyberTextureView", "release called mSurfaceTexture:" + this.f4961b);
        Surface surface = this.f4962c;
        if (surface != null) {
            surface.release();
            this.f4962c = null;
        }
        this.f4961b = null;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a(int i2, int i3, int i4, int i5) {
        if (this.f4964e.a(i2, i3, i4, i5)) {
            f();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void b() {
        SurfaceTexture surfaceTexture = this.f4961b;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f4961b = null;
        }
        a();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void c() {
        setRotation(0.0f);
        this.f4964e.a();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Surface d() {
        CyberLog.d("CyberTextureView", "createNewSurface mSurface:" + this.f4962c);
        Surface surface = this.f4962c;
        if (surface != null) {
            surface.release();
            this.f4962c = null;
        }
        CyberLog.d("CyberTextureView", "createNewSurface getSurfaceTexture:" + getSurfaceTexture());
        if (getSurfaceTexture() != null) {
            this.f4962c = new Surface(getSurfaceTexture());
            this.f4961b = getSurfaceTexture();
            this.f4965f = false;
        }
        CyberLog.d("CyberTextureView", "createNewSurface mSurface:" + this.f4962c);
        return this.f4962c;
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
    public void onMeasure(int i2, int i3) {
        int i4;
        float f2;
        this.f4964e.a(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        this.f4964e.b();
        boolean z = this.f4964e.g() == 90 || this.f4964e.g() == 270;
        if (z) {
            i3 = i2;
            i2 = i3;
        }
        int defaultSize = View.getDefaultSize(this.f4964e.h(), i2);
        int defaultSize2 = View.getDefaultSize(this.f4964e.i(), i3);
        float[] c2 = this.f4964e.c();
        if (z) {
            i4 = (int) (c2[1] * defaultSize);
            f2 = c2[0];
        } else {
            i4 = (int) (c2[0] * defaultSize);
            f2 = c2[1];
        }
        int i5 = (int) (f2 * defaultSize2);
        setMeasuredDimension(i4, i5);
        b(defaultSize, defaultSize2, i4, i5);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setClientRotation(int i2) {
        if (this.f4964e.b(i2)) {
            a(i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setCyberSurfaceListener(i.a aVar) {
        this.f4963d = aVar;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setDisplayMode(int i2) {
        if (this.f4964e.c(i2)) {
            f();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setRawFrameRotation(int i2) {
        if (this.f4964e.a(i2)) {
            a(i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setZOrderMediaOverlay(boolean z) {
    }
}
