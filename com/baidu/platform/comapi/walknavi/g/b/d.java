package com.baidu.platform.comapi.walknavi.g.b;

import android.os.Handler;
import android.view.View;
/* loaded from: classes2.dex */
public class d extends com.baidu.platform.comapi.wnplatform.o.m {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f9651a;

    public d(c cVar) {
        this.f9651a = cVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.m
    public void a(View view) {
        Handler handler;
        Handler handler2;
        if (com.baidu.platform.comapi.walknavi.b.a().t()) {
            handler = this.f9651a.n;
            if (handler != null) {
                c cVar = this.f9651a;
                if (cVar.i != null) {
                    handler2 = cVar.n;
                    handler2.removeCallbacks(this.f9651a.i);
                }
            }
            com.baidu.platform.comapi.walknavi.b.a().a(1, false);
        }
    }
}
