package com.baidu.mapsdkplatform.comapi.map;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes6.dex */
public class MapRenderer implements GLSurfaceView.Renderer {
    private static final String d = MapRenderer.class.getSimpleName();
    public int a;
    public int b;
    public int c;
    private long e;
    private a f;
    private final j g;

    /* loaded from: classes6.dex */
    public interface a {
        void f();
    }

    public MapRenderer(j jVar, a aVar) {
        this.f = aVar;
        this.g = jVar;
    }

    private void a(GL10 gl10) {
        GLES20.glClear(16640);
        GLES20.glClearColor(0.85f, 0.8f, 0.8f, 0.0f);
    }

    private boolean a() {
        return this.e != 0;
    }

    public static native void nativeInit(long j);

    public static native int nativeRender(long j);

    public static native void nativeResize(long j, int i, int i2);

    public void a(long j) {
        this.e = j;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (!a()) {
            a(gl10);
            return;
        }
        if (this.c <= 1) {
            nativeResize(this.e, this.a, this.b);
            this.c++;
        }
        this.f.f();
        int nativeRender = nativeRender(this.e);
        if (this.g.a() != null) {
            if (this.g.a().h != null) {
                for (l lVar : this.g.a().h) {
                    if (this.g.a() == null) {
                        return;
                    }
                    ab I = this.g.a().I();
                    if (lVar != null) {
                        lVar.a(gl10, I);
                    }
                }
            }
            j jVar = this.g;
            if (nativeRender == 1) {
                jVar.requestRender();
            } else if (this.g.a().b()) {
                if (jVar.getRenderMode() != 1) {
                    jVar.setRenderMode(1);
                }
            } else if (jVar.getRenderMode() != 0) {
                jVar.setRenderMode(0);
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        if (this.e != 0) {
            nativeResize(this.e, i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        nativeInit(this.e);
        if (a()) {
            this.f.f();
        }
    }
}
