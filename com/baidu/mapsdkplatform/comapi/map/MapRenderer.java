package com.baidu.mapsdkplatform.comapi.map;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class MapRenderer implements GLSurfaceView.Renderer {

    /* renamed from: d  reason: collision with root package name */
    public static final String f7560d = MapRenderer.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public int f7561a;

    /* renamed from: b  reason: collision with root package name */
    public int f7562b;

    /* renamed from: c  reason: collision with root package name */
    public int f7563c;

    /* renamed from: e  reason: collision with root package name */
    public long f7564e;

    /* renamed from: f  reason: collision with root package name */
    public a f7565f;

    /* renamed from: g  reason: collision with root package name */
    public final j f7566g;

    /* loaded from: classes2.dex */
    public interface a {
        void f();
    }

    public MapRenderer(j jVar, a aVar) {
        this.f7565f = aVar;
        this.f7566g = jVar;
    }

    private void a(GL10 gl10) {
        GLES20.glClear(16640);
        GLES20.glClearColor(0.85f, 0.8f, 0.8f, 0.0f);
    }

    private boolean a() {
        return this.f7564e != 0;
    }

    public static native void nativeInit(long j);

    public static native int nativeRender(long j);

    public static native void nativeResize(long j, int i2, int i3);

    public void a(long j) {
        this.f7564e = j;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (!a()) {
            a(gl10);
            return;
        }
        if (this.f7563c <= 1) {
            nativeResize(this.f7564e, this.f7561a, this.f7562b);
            this.f7563c++;
        }
        this.f7565f.f();
        int nativeRender = nativeRender(this.f7564e);
        if (this.f7566g.a() == null) {
            return;
        }
        if (this.f7566g.a().f7624h != null) {
            for (l lVar : this.f7566g.a().f7624h) {
                if (this.f7566g.a() == null) {
                    return;
                }
                ab J = this.f7566g.a().J();
                if (lVar != null) {
                    lVar.a(gl10, J);
                }
            }
        }
        j jVar = this.f7566g;
        if (nativeRender == 1) {
            jVar.requestRender();
        } else if (jVar.a().b()) {
            if (jVar.getRenderMode() != 1) {
                jVar.setRenderMode(1);
            }
        } else if (jVar.getRenderMode() != 0) {
            jVar.setRenderMode(0);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        long j = this.f7564e;
        if (j != 0) {
            nativeResize(j, i2, i3);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        nativeInit(this.f7564e);
        if (a()) {
            this.f7565f.f();
        }
    }
}
