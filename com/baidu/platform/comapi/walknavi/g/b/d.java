package com.baidu.platform.comapi.walknavi.g.b;

import android.os.Handler;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d extends com.baidu.platform.comapi.wnplatform.o.m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f2974a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f2974a = cVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.m
    public void a(View view) {
        Handler handler;
        Handler handler2;
        if (com.baidu.platform.comapi.walknavi.b.a().t()) {
            handler = this.f2974a.n;
            if (handler != null && this.f2974a.i != null) {
                handler2 = this.f2974a.n;
                handler2.removeCallbacks(this.f2974a.i);
            }
            com.baidu.platform.comapi.walknavi.b.a().a(1, false);
        }
    }
}
