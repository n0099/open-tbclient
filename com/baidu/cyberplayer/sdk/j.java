package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.cyberplayer.sdk.i;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes3.dex */
public class j extends SurfaceView implements i {
    public i.a a;
    public a b;
    public Surface c;
    public h d;
    public boolean e;
    public boolean f;
    public boolean g;

    @Override // com.baidu.cyberplayer.sdk.i
    public Bitmap a(float f, int i, int i2) {
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a() {
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public boolean a(int i, float f, float f2, float f3, float f4) {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public boolean e() {
        return true;
    }

    public SurfaceTexture getSurfaceTexture() {
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setClientRotation(int i) {
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setRawFrameRotation(int i) {
    }

    /* loaded from: classes3.dex */
    public class a implements SurfaceHolder.Callback {
        public a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            CyberLog.d("CyberSurfaceView", "surfaceChanged: " + i2 + " x " + i3);
            if (j.this.a != null) {
                j.this.a.a(i2, i3);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            CyberLog.d("CyberSurfaceView", "surfaceCreated mCyberSurfaceListener:" + j.this.a);
            j.this.c = surfaceHolder.getSurface();
            if (j.this.a != null) {
                j.this.a.a(2);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CyberLog.d("CyberSurfaceView", "surfaceDestroyed mCyberSurfaceListener:" + j.this.a);
            if (j.this.c != null) {
                j.this.c.release();
                j.this.c = null;
            }
            if (j.this.a != null) {
                j.this.a.b(2);
            }
        }
    }

    public j(Context context) {
        super(context);
        this.e = false;
        this.f = false;
        this.g = false;
        CyberLog.d("CyberSurfaceView", "CyberSurfaceView constructor called");
        getHolder().setType(0);
        getHolder().setFixedSize(1920, 1080);
        this.b = new a();
        getHolder().addCallback(this.b);
        this.d = new h();
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f) {
            CyberLog.d("CyberSurfaceView", "FirstDisplay!!!");
            this.f = true;
            i.a aVar = this.a;
            if (aVar != null) {
                aVar.a(System.currentTimeMillis());
            }
            setWillNotDraw(true);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setCyberSurfaceListener(i.a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setDisplayMode(int i) {
        if (this.d.c(i)) {
            CyberLog.i("CyberSurfaceView", "setDisplayMode to " + i);
            this.d.c();
            requestLayout();
        }
    }

    @Override // android.view.SurfaceView, com.baidu.cyberplayer.sdk.i
    public void setZOrderMediaOverlay(boolean z) {
        super.setZOrderMediaOverlay(z);
    }

    private void b(int i, int i2, int i3, int i4) {
        if (this.d.g()) {
            CyberLog.i("CyberSurfaceView", "doTranslate lastWidth:" + i + " lastHeight:" + i2 + " width:" + i3 + " height:" + i4);
            float f = ((float) (i3 - i)) / 2.0f;
            float f2 = ((float) (i4 - i2)) / 2.0f;
            StringBuilder sb = new StringBuilder();
            sb.append("doTranslate x:");
            sb.append(f);
            sb.append(" y:");
            sb.append(f2);
            CyberLog.i("CyberSurfaceView", sb.toString());
            int e = this.d.e();
            if (e == 7) {
                setTranslationX(-f);
                setTranslationY(0.0f);
            } else if (e == 8) {
                setTranslationX(f);
                setTranslationY(0.0f);
            } else if (e == 9) {
                setTranslationX(0.0f);
                setTranslationY(-f2);
            } else if (e == 10) {
                setTranslationX(0.0f);
                setTranslationY(f2);
            }
            this.e = true;
        } else if (this.e) {
            setTranslationX(0.0f);
            setTranslationY(0.0f);
            this.e = false;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a(int i, int i2, int i3, int i4) {
        if (this.d.a(i, i2, i3, i4)) {
            CyberLog.i("CyberSurfaceView", "onVideoSizeChanged:" + i + "/" + i2 + "/" + i3 + "/" + i4);
            requestLayout();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void b() {
        Surface surface = this.c;
        if (surface != null) {
            surface.release();
            this.c = null;
        }
        c();
        if (this.b != null) {
            getHolder().removeCallback(this.b);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void c() {
        this.d.a();
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        this.e = false;
        this.f = false;
        this.g = false;
        setWillNotDraw(false);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Surface d() {
        CyberLog.d("CyberSurfaceView", "mSurface:" + this.c);
        if (this.c == null) {
            this.c = getHolder().getSurface();
        }
        Surface surface = this.c;
        if (surface != null && !surface.isValid()) {
            CyberLog.i("CyberSurfaceView", "createNewSurface isValid:" + this.c.isValid());
            this.c = null;
        }
        if (this.g) {
            q.a(this.c);
        }
        if (this.c != null) {
            this.g = true;
        }
        return this.c;
    }

    public void finalize() throws Throwable {
        super.finalize();
        CyberLog.d("CyberSurfaceView", "CyberSurfaceView finalize called mSurface:" + this.c);
        Surface surface = this.c;
        if (surface != null) {
            surface.release();
            this.c = null;
        }
        c();
        if (this.b != null) {
            getHolder().removeCallback(this.b);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        float f;
        CyberLog.i("CyberSurfaceView", "onMeasure(" + View.MeasureSpec.toString(i) + StringUtil.ARRAY_ELEMENT_SEPARATOR + View.MeasureSpec.toString(i2) + SmallTailInfo.EMOTION_SUFFIX);
        this.d.a(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.d.c();
        if (this.d.h() != 90 && this.d.h() != 270) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            i2 = i;
            i = i2;
        }
        int defaultSize = View.getDefaultSize(this.d.i(), i);
        int defaultSize2 = View.getDefaultSize(this.d.j(), i2);
        float[] d = this.d.d();
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
