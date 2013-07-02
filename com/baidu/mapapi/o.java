package com.baidu.mapapi;

import android.graphics.Bitmap;
import android.graphics.Canvas;
/* loaded from: classes.dex */
final class o {
    private Bitmap a = null;
    private Canvas b = null;
    private Bitmap.Config c;

    public o(Bitmap.Config config) {
        this.c = config;
    }

    public final void a() {
        if (this.a != null) {
            this.a.recycle();
        }
        this.a = null;
        this.b = null;
    }

    public final void a(int i, int i2) {
        a();
        this.a = Bitmap.createBitmap(i, i2, this.c);
        this.b = new Canvas(this.a);
    }

    public final void a(p pVar) {
        this.b.save(1);
        pVar.a(this.b);
        this.b.restore();
    }

    public final Bitmap b() {
        return this.a;
    }
}
