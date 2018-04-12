package com.baidu.ar.recorder.drawer;

import android.content.Context;
import android.support.annotation.RequiresApi;
import com.baidu.ar.recorder.filter.FilterManager;
@RequiresApi(api = 18)
/* loaded from: classes3.dex */
public class d {
    private com.baidu.ar.recorder.c.b a;
    private c b;
    private b c;

    public d(b bVar) {
        this.c = bVar;
        this.a = new com.baidu.ar.recorder.c.b(bVar.a(), 1);
    }

    private com.baidu.ar.recorder.filter.c a(Context context, b bVar) {
        return bVar.f() ? FilterManager.a(context, bVar.h()) : FilterManager.b(context, bVar.h());
    }

    public com.baidu.ar.recorder.c.b a() {
        return this.a;
    }

    public void a(Context context) {
        this.b = new c(this.c.c(), this.c.g(), a(context, this.c));
        this.b.c();
    }

    public void a(Context context, FilterManager.FilterType filterType) {
        this.c.a(filterType);
        this.b.a(a(context, this.c));
    }

    public void a(float[] fArr) {
        this.b.a(this.c.b(), fArr, false, false);
    }

    public void b() {
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
        if (this.b != null) {
            this.b.a(true);
            this.b = null;
        }
    }
}
