package com.baidu.ar.draw;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class ARRenderer implements GLSurfaceView.Renderer {
    private static final String a = ARRenderer.class.getSimpleName();
    private a b;
    private SurfaceTexture c;
    private int d;
    private SurfaceTexture.OnFrameAvailableListener e;
    private a f;
    private SurfaceTexture g;
    private int h;
    private int i;
    private int j;
    private ARRenderCallback k;
    private SurfaceTexture.OnFrameAvailableListener l;
    private boolean n;
    private volatile boolean m = true;
    private boolean o = false;

    public ARRenderer(boolean z) {
        this.n = z;
        if (this.c == null) {
            this.c = new SurfaceTexture(a(3553));
        }
        if (this.g == null) {
            this.g = new SurfaceTexture(a(3553));
        }
    }

    private int a(int i) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(i, iArr[0]);
        GLES20.glTexParameterf(i, 10241, 9729.0f);
        GLES20.glTexParameterf(i, 10240, 9729.0f);
        GLES20.glTexParameteri(i, 10242, 33071);
        GLES20.glTexParameteri(i, 10243, 33071);
        return iArr[0];
    }

    private void a() {
        if (this.c == null || this.e == null) {
            return;
        }
        this.c.setOnFrameAvailableListener(this.e);
    }

    private void b() {
        if (this.o) {
            try {
                this.g.detachFromGLContext();
            } catch (Exception e) {
                Log.e(a, "onSurfaceChanged attachToGLContext error!!!");
                e.printStackTrace();
            }
            try {
                this.c.detachFromGLContext();
            } catch (Exception e2) {
                Log.e(a, "onSurfaceChanged attachToGLContext error!!!");
                e2.printStackTrace();
            }
            try {
                if (this.m) {
                    this.g.attachToGLContext(this.h);
                } else {
                    this.c.attachToGLContext(this.d);
                }
            } catch (Exception e3) {
                Log.e(a, "onSurfaceChanged attachToGLContext error!!!");
                e3.printStackTrace();
            }
            this.o = false;
        }
    }

    public SurfaceTexture getCameraTexture() {
        return this.c;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        b();
        if (StatisticConstants.getIsRenderModel()) {
            StatisticHelper.getInstance().statisticFrameRate(StatisticConstants.VIEW_RENDER_FRAME_TIME);
        }
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glClear(16640);
        try {
            if (this.m) {
                if (this.g != null) {
                    Log.d(a, "mARTexture.updateTexImage(); ");
                    this.g.updateTexImage();
                    float[] fArr = new float[16];
                    this.g.getTransformMatrix(fArr);
                    this.f.a(fArr);
                }
            } else if (this.c != null) {
                this.c.updateTexImage();
                float[] fArr2 = new float[16];
                this.c.getTransformMatrix(fArr2);
                this.b.a(fArr2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        this.i = i;
        this.j = i2;
        if (this.b == null) {
            this.b = new a(this.d, 3553, this.n);
        }
        if (this.f == null) {
            this.f = new a(this.h, 3553, this.n);
        }
        if (this.k != null) {
            this.k.onARDrawerChanged(this.g, this.i, this.j);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.d = a(3553);
        this.h = a(3553);
    }

    public void release() {
        if (this.f != null) {
            this.f = null;
        }
        if (this.g != null) {
            this.g.release();
            this.g = null;
        }
        this.k = null;
    }

    public void setARFrameListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        this.l = onFrameAvailableListener;
    }

    public void setARRenderCallback(ARRenderCallback aRRenderCallback) {
        this.k = aRRenderCallback;
        if (this.k != null) {
            this.k.onCameraDrawerCreated(this.c, 1280, 720);
        }
        if (this.k != null) {
            this.k.onARDrawerCreated(this.g, this.l, this.i, this.j);
        }
    }

    public void setCameraFrameListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        this.e = onFrameAvailableListener;
        a();
    }

    public void setDrawAR(boolean z) {
        this.m = z;
        this.o = true;
    }
}
