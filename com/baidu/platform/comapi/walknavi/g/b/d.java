package com.baidu.platform.comapi.walknavi.g.b;

import android.os.Handler;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class d extends com.baidu.platform.comapi.wnplatform.o.m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f4298a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f4298a = cVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.m
    public void a(View view) {
        Handler handler;
        Handler handler2;
        if (com.baidu.platform.comapi.walknavi.b.a().t()) {
            handler = this.f4298a.n;
            if (handler != null && this.f4298a.i != null) {
                handler2 = this.f4298a.n;
                handler2.removeCallbacks(this.f4298a.i);
            }
            com.baidu.platform.comapi.walknavi.b.a().a(1, false);
        }
    }
}
