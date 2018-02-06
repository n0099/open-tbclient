package com.baidu.ar.recorder.drawer;

import android.view.Surface;
/* loaded from: classes3.dex */
public class g extends com.baidu.ar.recorder.c.c {
    private Surface c;
    private boolean d;

    public g(com.baidu.ar.recorder.c.b bVar, Surface surface, boolean z) {
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

    public void a(com.baidu.ar.recorder.c.b bVar) {
        if (this.c == null) {
            throw new RuntimeException("not yet implemented for SurfaceTexture");
        }
        this.b = bVar;
        a(this.c);
    }
}
