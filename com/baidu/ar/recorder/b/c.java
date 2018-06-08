package com.baidu.ar.recorder.b;

import android.content.Context;
import com.baidu.ar.recorder.filter.FilterManager;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.ar.recorder.e.b a;
    private b b;
    private a c;

    public c(a aVar) {
        this.c = aVar;
        this.a = new com.baidu.ar.recorder.e.b(aVar.a(), 1);
    }

    private com.baidu.ar.recorder.filter.c a(Context context, a aVar) {
        return aVar.f() ? FilterManager.a(context, aVar.h()) : FilterManager.b(context, aVar.h());
    }

    public com.baidu.ar.recorder.e.b a() {
        return this.a;
    }

    public void a(Context context) {
        this.b = new b(this.c.c(), this.c.g(), a(context, this.c));
        this.b.a();
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
