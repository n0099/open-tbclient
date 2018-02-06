package com.baidu.ar.recorder.c;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes3.dex */
public class c {
    protected static final String a = c.class.getSimpleName();
    protected b b;
    private EGLSurface c = EGL14.EGL_NO_SURFACE;
    private int d = -1;
    private int e = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(b bVar) {
        this.b = bVar;
    }

    public void a(long j) {
        this.b.a(this.c, j);
    }

    public void a(Object obj) {
        if (this.c != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.c = this.b.a(obj);
    }

    public void b() {
        this.b.a(this.c);
        this.c = EGL14.EGL_NO_SURFACE;
        this.e = -1;
        this.d = -1;
    }

    public void b(b bVar) {
        if (bVar.d(this.c)) {
            return;
        }
        bVar.b(this.c);
    }

    public boolean c() {
        boolean c = this.b.c(this.c);
        if (!c) {
            Log.d(a, "WARNING: swapBuffers() failed");
        }
        return c;
    }
}
