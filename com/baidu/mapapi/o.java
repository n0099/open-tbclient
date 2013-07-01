package com.baidu.mapapi;

import android.graphics.Bitmap;
import android.graphics.Canvas;
/* loaded from: classes.dex */
final class o {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f564a = null;
    private Canvas b = null;
    private Bitmap.Config c;

    public o(Bitmap.Config config) {
        this.c = config;
    }

    public final void a() {
        if (this.f564a != null) {
            this.f564a.recycle();
        }
        this.f564a = null;
        this.b = null;
    }

    public final void a(int i, int i2) {
        a();
        this.f564a = Bitmap.createBitmap(i, i2, this.c);
        this.b = new Canvas(this.f564a);
    }

    public final void a(p pVar) {
        this.b.save(1);
        pVar.a(this.b);
        this.b.restore();
    }

    public final Bitmap b() {
        return this.f564a;
    }
}
