package com.baidu.ar;

import android.content.Context;
import android.opengl.EGL14;
import android.util.Log;
import com.baidu.ar.opengl.BaiduArView;
import com.baidu.ar.recorder.drawer.RectDrawableParams;
import com.baidu.ar.recorder.encoder.EncoderParams;
import com.baidu.ar.recorder.filter.FilterManager;
import javax.microedition.khronos.egl.EGLContext;
/* loaded from: classes3.dex */
public class b implements BaiduArView.b {
    private static final String b = b.class.getSimpleName();
    private com.baidu.ar.recorder.drawer.b c;
    private final Context e;
    private FilterManager.FilterType f;
    private EncoderParams i;
    private com.baidu.ar.recorder.b j;
    private boolean k;
    private int l;
    private int d = -1;
    private boolean g = false;
    float[] a = new float[16];
    private com.baidu.ar.recorder.a h = com.baidu.ar.recorder.a.a();

    public b(Context context) {
        this.e = context;
        com.baidu.ar.representation.a.a(this.a, 0);
    }

    private void a(int i, float[] fArr, long j) {
        if (this.k && this.i != null) {
            switch (this.l) {
                case 0:
                    this.h.a(this.e, this.i, this.j);
                    this.l = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.c.a(i);
                    this.c.a(this.f);
                    this.h.b(this.c);
                    this.l = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.l);
            }
        }
        if (this.h != null) {
            this.h.a(fArr, j);
        }
    }

    private void b() {
        if (this.g) {
            if (this.h != null) {
                this.h.a(this.f);
            }
            this.g = false;
        }
    }

    public void a() {
        Log.d(b, "stopRecord!!!");
        this.k = false;
        switch (this.l) {
            case 0:
                return;
            case 1:
            case 2:
                this.l = 0;
                this.h.c();
                return;
            default:
                throw new RuntimeException("unknown status " + this.l);
        }
    }

    @Override // com.baidu.ar.opengl.BaiduArView.b
    public void a(int i) {
        if (this.c == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.c != null && this.d != i) {
            Log.d(b, "onFrameAvailable textureId = " + i);
            this.c.a(i);
            com.baidu.ar.recorder.a.a().a(this.c.a(), i);
            this.d = i;
        }
        b();
        a(this.d, this.a, System.nanoTime());
        com.baidu.ar.util.b.d("bdar: onFrameAvailable time is = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void a(com.baidu.ar.recorder.b bVar) {
        Log.d(b, "startRecord!!!");
        if (bVar != null) {
            this.j = bVar;
        }
        this.k = true;
    }

    public void a(EncoderParams encoderParams) {
        this.i = encoderParams;
    }

    @Override // com.baidu.ar.opengl.BaiduArView.b
    public void a(EGLContext eGLContext, int i, int i2) {
        Log.d(b, "onContextChanged width*height = " + i + " * " + i2);
        if (eGLContext == null) {
            return;
        }
        if (this.c == null) {
            this.c = new com.baidu.ar.recorder.drawer.b(EGL14.eglGetCurrentContext(), 0, true, false);
        } else {
            this.c.a(EGL14.eglGetCurrentContext());
        }
        RectDrawableParams rectDrawableParams = new RectDrawableParams();
        rectDrawableParams.c(i);
        rectDrawableParams.d(i2);
        this.c.a(rectDrawableParams);
        com.baidu.ar.recorder.a.a().a(this.c);
    }

    public void b(int i) {
        this.h.a(i);
    }

    public void b(EncoderParams encoderParams) {
        a(encoderParams);
    }
}
