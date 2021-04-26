package com.baidu.platform.comapi.wnplatform.n;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.baidu.mapapi.map.MapView;
/* loaded from: classes2.dex */
public abstract class a extends com.baidu.platform.comapi.walknavi.a implements com.baidu.platform.comapi.wnplatform.c.a, com.baidu.platform.comapi.wnplatform.h.a, com.baidu.platform.comapi.wnplatform.h.b, com.baidu.platform.comapi.wnplatform.i.a {
    public void a(Context context, View view, int i2, int i3, int i4, int i5) {
        if (view == null || !(view instanceof MapView)) {
            return;
        }
        ((MapView) view).getMap().setViewPadding(a(context, i2), a(context, i3), a(context, i4), a(context, i5));
    }

    public abstract void a(com.baidu.platform.comapi.walknavi.g.b.a aVar);

    public abstract void a(String str);

    public abstract void a(boolean z);

    public abstract void b(int i2);

    public abstract void c(int i2);

    public abstract boolean c();

    public abstract void d();

    public abstract void e();

    public abstract int f();

    public abstract int g();

    public abstract View h();

    public abstract void i();

    public abstract int j();

    public abstract void l();

    public abstract int n();

    public abstract void o();

    public abstract void q();

    public abstract float r();

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
    }

    public abstract Handler t();

    private int a(Context context, int i2) {
        return (int) ((context.getResources().getDisplayMetrics().density * i2) + 0.5f);
    }
}
