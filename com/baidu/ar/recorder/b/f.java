package com.baidu.ar.recorder.b;

import android.view.Surface;
/* loaded from: classes3.dex */
public class f extends com.baidu.ar.recorder.e.c {
    private Surface c;
    private boolean d;

    public f(com.baidu.ar.recorder.e.b bVar, Surface surface, boolean z) {
        super(bVar);
        a(surface);
        this.c = surface;
        this.d = z;
    }

    public void a() {
        b();
        if (this.c != null) {
            if (this.d) {
                this.c.release();
            }
            this.c = null;
        }
    }

    public void a(com.baidu.ar.recorder.e.b bVar) {
        if (this.c == null) {
            throw new RuntimeException("not yet implemented for SurfaceTexture");
        }
        this.b = bVar;
        a(this.c);
    }
}
