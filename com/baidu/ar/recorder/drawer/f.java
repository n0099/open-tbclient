package com.baidu.ar.recorder.drawer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.ar.recorder.filter.FilterManager;
/* loaded from: classes3.dex */
public class f {
    private Context a;
    private SurfaceTexture b;
    private c c;
    private b d;

    public f(Context context, b bVar, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        this.a = context;
        this.d = bVar;
        try {
            this.c = new c(bVar.c(), bVar.g(), FilterManager.a(context, bVar.h()));
            int b = this.c.b();
            this.b = new SurfaceTexture(b);
            this.b.setOnFrameAvailableListener(onFrameAvailableListener);
            this.d.a(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SurfaceTexture a() {
        return this.b;
    }

    public void a(b bVar, float[] fArr) {
        try {
            this.b.updateTexImage();
            this.c.a().a(bVar.g().c(), bVar.g().d());
            this.b.getTransformMatrix(fArr);
            this.c.a(bVar.b(), fArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(FilterManager.FilterType filterType) {
        if (this.d == null || this.c == null) {
            return;
        }
        this.d.a(filterType);
        this.c.a(FilterManager.a(this.a, this.d.h()));
    }

    public void b() {
        this.c.c();
    }
}
