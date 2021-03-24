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
    public a f4946a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceTexture f4947b;

    /* renamed from: c  reason: collision with root package name */
    public Surface f4948c;

    /* renamed from: d  reason: collision with root package name */
    public i.a f4949d;

    /* renamed from: e  reason: collision with root package name */
    public f f4950e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4951f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4952g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4953h;

    /* loaded from: classes2.dex */
    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            CyberLog.d("CyberTextureView", "onSurfaceTextureAvailable surface:" + surfaceTexture + " width:" + i + " height:" + i2);
            if (h.this.f4947b == null) {
                h.this.f4947b = surfaceTexture;
                if (h.this.f4949d == null) {
                    return;
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                h hVar = h.this;
                hVar.setSurfaceTexture(hVar.f4947b);
                return;
            } else {
                h.this.f4947b = surfaceTexture;
                if (h.this.f4949d == null) {
                    return;
                }
            }
            h.this.f4949d.a(1);
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
            if (h.this.f4951f) {
                return;
            }
            h.this.f4951f = true;
            if (h.this.f4949d != null) {
                h.this.f4949d.a(System.currentTimeMillis());
            }
        }
    }

    public h(Context context) {
        super(context);
        this.f4953h = false;
        a aVar = new a();
        this.f4946a = aVar;
        setSurfaceTextureListener(aVar);
        this.f4950e = new f();
        this.f4951f = false;
        this.f4952g = CyberCfgManager.getInstance().a("textureview_enable_translate", true);
    }

    private void a(int i) {
        int g2 = this.f4950e.g();
        if (g2 > 0) {
            g2 = 360 - g2;
        }
        CyberLog.i("CyberTextureView", "updateRotation rotate:" + i + " drawFrameRotation:" + g2);
        setRotation((float) g2);
        requestLayout();
    }

    private void b(int i, int i2, int i3, int i4) {
        boolean z;
        if (this.f4952g) {
            if (this.f4950e.f()) {
                Matrix matrix = new Matrix();
                getTransform(matrix);
                CyberLog.i("CyberTextureView", "doTranslate old_width:" + i + " old_height:" + i2 + " width:" + i3 + " height:" + i4);
                float f2 = ((float) (i3 - i)) / 2.0f;
                float f3 = ((float) (i4 - i2)) / 2.0f;
                StringBuilder sb = new StringBuilder();
                sb.append("doTranslate x:");
                sb.append(f2);
                sb.append(" y:");
                sb.append(f3);
                CyberLog.i("CyberTextureView", sb.toString());
                int d2 = this.f4950e.d();
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
            } else if (!this.f4953h) {
                return;
            } else {
                Matrix matrix2 = new Matrix();
                getTransform(matrix2);
                matrix2.setTranslate(0.0f, 0.0f);
                setTransform(matrix2);
                z = false;
            }
            this.f4953h = z;
        }
    }

    private void f() {
        requestLayout();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Bitmap a(float f2, int i, int i2) {
        return getBitmap();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a() {
        CyberLog.d("CyberTextureView", "release called mSurfaceTexture:" + this.f4947b);
        Surface surface = this.f4948c;
        if (surface != null) {
            surface.release();
            this.f4948c = null;
        }
        this.f4947b = null;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a(int i, int i2, int i3, int i4) {
        if (this.f4950e.a(i, i2, i3, i4)) {
            f();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void b() {
        SurfaceTexture surfaceTexture = this.f4947b;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f4947b = null;
        }
        a();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void c() {
        setRotation(0.0f);
        this.f4950e.a();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Surface d() {
        CyberLog.d("CyberTextureView", "createNewSurface mSurface:" + this.f4948c);
        Surface surface = this.f4948c;
        if (surface != null) {
            surface.release();
            this.f4948c = null;
        }
        CyberLog.d("CyberTextureView", "createNewSurface getSurfaceTexture:" + getSurfaceTexture());
        if (getSurfaceTexture() != null) {
            this.f4948c = new Surface(getSurfaceTexture());
            this.f4947b = getSurfaceTexture();
            this.f4951f = false;
        }
        CyberLog.d("CyberTextureView", "createNewSurface mSurface:" + this.f4948c);
        return this.f4948c;
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
    public void onMeasure(int i, int i2) {
        int i3;
        float f2;
        this.f4950e.a(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.f4950e.b();
        boolean z = this.f4950e.g() == 90 || this.f4950e.g() == 270;
        if (z) {
            i2 = i;
            i = i2;
        }
        int defaultSize = View.getDefaultSize(this.f4950e.h(), i);
        int defaultSize2 = View.getDefaultSize(this.f4950e.i(), i2);
        float[] c2 = this.f4950e.c();
        if (z) {
            i3 = (int) (c2[1] * defaultSize);
            f2 = c2[0];
        } else {
            i3 = (int) (c2[0] * defaultSize);
            f2 = c2[1];
        }
        int i4 = (int) (f2 * defaultSize2);
        setMeasuredDimension(i3, i4);
        b(defaultSize, defaultSize2, i3, i4);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setClientRotation(int i) {
        if (this.f4950e.b(i)) {
            a(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setCyberSurfaceListener(i.a aVar) {
        this.f4949d = aVar;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setDisplayMode(int i) {
        if (this.f4950e.c(i)) {
            f();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setRawFrameRotation(int i) {
        if (this.f4950e.a(i)) {
            a(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setZOrderMediaOverlay(boolean z) {
    }
}
