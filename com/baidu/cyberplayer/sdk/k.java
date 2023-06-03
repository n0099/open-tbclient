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
/* loaded from: classes3.dex */
public class k extends TextureView implements i {
    public a a;
    public SurfaceTexture b;
    public Surface c;
    public i.a d;
    public h e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;

    @Override // com.baidu.cyberplayer.sdk.i
    public boolean a(int i, float f, float f2, float f3, float f4) {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public boolean e() {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setZOrderMediaOverlay(boolean z) {
    }

    /* loaded from: classes3.dex */
    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (k.this.f) {
                return;
            }
            k.this.f = true;
            if (k.this.d != null) {
                k.this.d.a(System.currentTimeMillis());
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            CyberLog.d("CyberTextureView", "onSurfaceTextureAvailable surface:" + surfaceTexture + " width:" + i + " height:" + i2);
            k.this.h = false;
            if (k.this.i && !k.this.g) {
                k.this.a(surfaceTexture);
            }
            if (k.this.b != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    k kVar = k.this;
                    kVar.setSurfaceTexture(kVar.b);
                    return;
                }
                k.this.b = surfaceTexture;
                if (k.this.d != null) {
                    k.this.d.a(1);
                    return;
                }
                return;
            }
            k.this.b = surfaceTexture;
            if (k.this.d != null) {
                k.this.d.a(1);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            CyberLog.d("CyberTextureView", "onSurfaceTextureDestroyed surface:" + surfaceTexture);
            k.this.h = true;
            if (k.this.i && !k.this.g) {
                if (surfaceTexture != k.this.b && surfaceTexture != null) {
                    surfaceTexture.release();
                }
                k.this.g();
                return false;
            }
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            CyberLog.d("CyberTextureView", "onSurfaceTextureSizeChanged surface:" + surfaceTexture + " width:" + i + " height:" + i2);
            k.this.h = false;
        }
    }

    public k(Context context) {
        super(context);
        this.k = false;
        a aVar = new a();
        this.a = aVar;
        setSurfaceTextureListener(aVar);
        this.e = new h();
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = CyberCfgManager.getInstance().a("textureview_texture_auto_release", true);
        this.j = CyberCfgManager.getInstance().a("textureview_enable_translate", true);
    }

    private void a(int i) {
        int h = this.e.h();
        if (h > 0) {
            h = 360 - h;
        }
        CyberLog.i("CyberTextureView", "updateRotation rotate:" + i + " drawFrameRotation:" + h);
        setRotation((float) h);
        requestLayout();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.b;
        if (surfaceTexture2 != null && surfaceTexture2 != surfaceTexture) {
            CyberLog.i("CyberTextureView", "releaseLastSurfaceTexture mSurfaceTexture:" + this.b);
            g();
        }
    }

    private void b(int i, int i2, int i3, int i4) {
        if (!this.j) {
            return;
        }
        if (this.e.g()) {
            Matrix matrix = new Matrix();
            getTransform(matrix);
            CyberLog.i("CyberTextureView", "doTranslate old_width:" + i + " old_height:" + i2 + " width:" + i3 + " height:" + i4);
            float f = ((float) (i3 - i)) / 2.0f;
            float f2 = ((float) (i4 - i2)) / 2.0f;
            StringBuilder sb = new StringBuilder();
            sb.append("doTranslate x:");
            sb.append(f);
            sb.append(" y:");
            sb.append(f2);
            CyberLog.i("CyberTextureView", sb.toString());
            int e = this.e.e();
            if (e == 7) {
                matrix.setTranslate(-f, 0.0f);
            } else if (e == 8) {
                matrix.setTranslate(f, 0.0f);
            } else if (e == 9) {
                matrix.setTranslate(0.0f, -f2);
            } else if (e == 10) {
                matrix.setTranslate(0.0f, f2);
            }
            setTransform(matrix);
            this.k = true;
        } else if (this.k) {
            Matrix matrix2 = new Matrix();
            getTransform(matrix2);
            matrix2.setTranslate(0.0f, 0.0f);
            setTransform(matrix2);
            this.k = false;
        }
    }

    private void f() {
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SurfaceTexture surfaceTexture = this.b;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            CyberLog.i("CyberTextureView", "releaseSurfaceTexture mSurfaceTexture:" + this.b);
            this.b = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void b() {
        g();
        a();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void c() {
        setRotation(0.0f);
        this.e.a();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Bitmap a(float f, int i, int i2) {
        return getBitmap();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a() {
        CyberLog.d("CyberTextureView", "release called mSurfaceTexture:" + this.b);
        Surface surface = this.c;
        if (surface != null) {
            surface.release();
            this.c = null;
        }
        this.g = false;
        if (this.i) {
            if (this.h) {
                CyberLog.d("CyberTextureView", "release called mSurfaceTexture:" + this.b + " mIsDestoryed:" + this.h);
                g();
                return;
            }
            return;
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
    public Surface d() {
        CyberLog.d("CyberTextureView", "createNewSurface mSurface:" + this.c);
        Surface surface = this.c;
        if (surface != null) {
            surface.release();
            this.c = null;
        }
        CyberLog.d("CyberTextureView", "createNewSurface getSurfaceTexture:" + getSurfaceTexture());
        if (getSurfaceTexture() != null) {
            this.g = true;
            this.c = new Surface(getSurfaceTexture());
            if (this.i) {
                a(getSurfaceTexture());
            }
            this.b = getSurfaceTexture();
            this.f = false;
        }
        CyberLog.d("CyberTextureView", "createNewSurface mSurface:" + this.c);
        return this.c;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        float f;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.e.a(size, size2);
        this.e.c();
        i.a aVar = this.d;
        if (aVar != null) {
            aVar.a(size, size2);
        }
        if (this.e.h() != 90 && this.e.h() != 270) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            i2 = i;
            i = i2;
        }
        int defaultSize = View.getDefaultSize(this.e.i(), i);
        int defaultSize2 = View.getDefaultSize(this.e.j(), i2);
        float[] d = this.e.d();
        if (z) {
            i3 = (int) (d[1] * defaultSize);
            f = d[0];
        } else {
            i3 = (int) (d[0] * defaultSize);
            f = d[1];
        }
        int i4 = (int) (f * defaultSize2);
        setMeasuredDimension(i3, i4);
        b(defaultSize, defaultSize2, i3, i4);
    }
}
