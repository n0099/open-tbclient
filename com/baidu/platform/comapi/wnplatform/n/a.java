package com.baidu.platform.comapi.wnplatform.n;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.baidu.mapapi.map.MapView;
/* loaded from: classes6.dex */
public abstract class a extends com.baidu.platform.comapi.walknavi.a implements com.baidu.platform.comapi.wnplatform.c.a, com.baidu.platform.comapi.wnplatform.h.a, com.baidu.platform.comapi.wnplatform.h.b, com.baidu.platform.comapi.wnplatform.i.a {
    public abstract void a(com.baidu.platform.comapi.walknavi.g.b.a aVar);

    public abstract void a(String str);

    public abstract void a(boolean z);

    public abstract void b(int i);

    public abstract void c(int i);

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

    public abstract Handler t();

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public void a(Context context, View view, int i, int i2, int i3, int i4) {
        if (view != null && (view instanceof MapView)) {
            ((MapView) view).getMap().setViewPadding(a(context, i), a(context, i2), a(context, i3), a(context, i4));
        }
    }

    private int a(Context context, int i) {
        return (int) ((context.getResources().getDisplayMetrics().density * i) + 0.5f);
    }
}
