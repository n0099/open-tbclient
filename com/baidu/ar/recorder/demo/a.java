package com.baidu.ar.recorder.demo;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.support.annotation.RequiresApi;
import android.util.Log;
import com.baidu.ar.camera.CameraCallback;
import com.baidu.ar.camera.CameraController;
import com.baidu.ar.camera.CameraParams;
import com.baidu.ar.recorder.drawer.RectDrawableParams;
import com.baidu.ar.recorder.drawer.b;
import com.baidu.ar.recorder.drawer.f;
import com.baidu.ar.recorder.encoder.EncoderParams;
import com.baidu.ar.recorder.filter.FilterManager;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class a implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, CameraCallback {
    private static final String a = a.class.getSimpleName();
    private final Context b;
    private f d;
    private RectDrawableParams e;
    private b f;
    private CameraController j;
    private CameraParams k;
    private CameraCallback l;
    private EncoderParams n;
    private InterfaceC0034a o;
    private com.baidu.ar.recorder.b p;
    private boolean q;
    private int r;
    private final float[] c = new float[16];
    private boolean g = false;
    private boolean i = false;
    private com.baidu.ar.recorder.a m = com.baidu.ar.recorder.a.a();
    private FilterManager.FilterType h = FilterManager.FilterType.Normal;

    /* renamed from: com.baidu.ar.recorder.demo.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0034a {
        void a();
    }

    public a(Context context) {
        this.b = context;
    }

    @RequiresApi(api = 18)
    private void a(int i, float[] fArr, long j) {
        if (this.q && this.n != null) {
            switch (this.r) {
                case 0:
                    if (!this.g) {
                        this.f.a(i);
                        this.f.a(this.h);
                        this.m.a(this.f);
                        this.g = true;
                    }
                    this.m.a(this.b, this.n, this.p);
                    this.r = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.f.a(i);
                    this.f.a(this.h);
                    this.m.b(this.f);
                    this.r = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.r);
            }
        }
        if (this.m != null) {
            this.m.a(fArr, j);
        }
    }

    private void a(b bVar, float[] fArr) {
        this.d.a(bVar, fArr);
    }

    private void b() {
        this.q = this.m.b();
        if (this.q) {
            this.r = 2;
        } else {
            this.r = 0;
        }
    }

    @RequiresApi(api = 18)
    private void c() {
        if (this.d == null) {
            Matrix.setIdentityM(this.c, 0);
            this.f = new b(EGL14.eglGetCurrentContext(), 0, true, true);
            if (this.e == null) {
                this.e = new RectDrawableParams();
            }
            this.f.a(this.e);
            this.d = new f(this.b, this.f, this);
        }
    }

    private void d() {
        if (this.i) {
            if (this.d != null) {
                this.d.a(this.h);
            }
            if (this.m != null) {
                this.m.a(this.h);
            }
            this.i = false;
        }
    }

    public void a() {
    }

    public void a(int i) {
        this.m.a(i);
    }

    public void a(EncoderParams encoderParams) {
        this.n = encoderParams;
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onCameraRelease(boolean z) {
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onCameraSetup(boolean z) {
        if (z) {
            if (this.e == null) {
                this.e = new RectDrawableParams();
            }
            this.e.c(this.k.getPreviewHeight());
            this.e.d(this.k.getPreviewWidth());
            com.baidu.ar.recorder.drawer.a.a(this.e);
            if (this.d != null && this.j != null) {
                this.d.b();
                this.j.setSurfaceTexture(this.d.a());
            }
        }
        if (this.l != null) {
            this.l.onCameraSetup(z);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    @RequiresApi(api = 18)
    public void onDrawFrame(GL10 gl10) {
        d();
        a(this.f, this.c);
        a(this.f.b(), this.c, this.d.a().getTimestamp());
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onFlashClose(boolean z) {
        if (this.l != null) {
            this.l.onFlashClose(z);
        }
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onFlashOpen(boolean z) {
        if (this.l != null) {
            this.l.onFlashOpen(z);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.o != null) {
            this.o.a();
        }
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onPreviewCallbackSet(boolean z) {
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onPreviewStart(boolean z) {
        if (this.l != null) {
            this.l.onPreviewStart(z);
        }
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onPreviewStop(boolean z) {
        if (this.l != null) {
            this.l.onPreviewStop(z);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Log.d(a, "onSurfaceChanged width*height = " + i + "*" + i2);
        if (gl10 != null) {
            gl10.glViewport(0, 0, i, i2);
        }
        if (this.e != null) {
            this.e.a(i);
            this.e.b(i2);
            com.baidu.ar.recorder.drawer.a.a(this.e);
        }
        if (this.d == null || this.j == null) {
            return;
        }
        this.d.b();
        this.j.setSurfaceTexture(this.d.a());
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    @RequiresApi(api = 18)
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.d(a, "onSurfaceCreated !!!");
        b();
        c();
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onSurfaceHolderSet(boolean z) {
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onSurfaceTextureSet(boolean z) {
    }
}
