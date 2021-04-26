package com.baidu.mapsdkplatform.comapi.map;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class MapRenderer implements GLSurfaceView.Renderer {

    /* renamed from: d  reason: collision with root package name */
    public static final String f7863d = MapRenderer.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public int f7864a;

    /* renamed from: b  reason: collision with root package name */
    public int f7865b;

    /* renamed from: c  reason: collision with root package name */
    public int f7866c;

    /* renamed from: e  reason: collision with root package name */
    public long f7867e;

    /* renamed from: f  reason: collision with root package name */
    public a f7868f;

    /* renamed from: g  reason: collision with root package name */
    public final j f7869g;

    /* loaded from: classes2.dex */
    public interface a {
        void f();
    }

    public MapRenderer(j jVar, a aVar) {
        this.f7868f = aVar;
        this.f7869g = jVar;
    }

    private void a(GL10 gl10) {
        GLES20.glClear(16640);
        GLES20.glClearColor(0.85f, 0.8f, 0.8f, 0.0f);
    }

    private boolean a() {
        return this.f7867e != 0;
    }

    public static native void nativeInit(long j);

    public static native int nativeRender(long j);

    public static native void nativeResize(long j, int i2, int i3);

    public void a(long j) {
        this.f7867e = j;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (!a()) {
            a(gl10);
            return;
        }
        if (this.f7866c <= 1) {
            nativeResize(this.f7867e, this.f7864a, this.f7865b);
            this.f7866c++;
        }
        this.f7868f.f();
        int nativeRender = nativeRender(this.f7867e);
        if (this.f7869g.a() == null) {
            return;
        }
        if (this.f7869g.a().f7927h != null) {
            for (l lVar : this.f7869g.a().f7927h) {
                if (this.f7869g.a() == null) {
                    return;
                }
                ab I = this.f7869g.a().I();
                if (lVar != null) {
                    lVar.a(gl10, I);
                }
            }
        }
        j jVar = this.f7869g;
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
        long j = this.f7867e;
        if (j != 0) {
            nativeResize(j, i2, i3);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        nativeInit(this.f7867e);
        if (a()) {
            this.f7868f.f();
        }
    }
}
