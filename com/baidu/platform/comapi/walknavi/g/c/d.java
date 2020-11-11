package com.baidu.platform.comapi.walknavi.g.c;

import android.os.Handler;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d extends com.baidu.platform.comapi.wnplatform.p.n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f3030a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f3030a = cVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.p.n
    public void a(View view) {
        Handler handler;
        Handler handler2;
        if (com.baidu.platform.comapi.walknavi.b.a().w()) {
            handler = this.f3030a.n;
            if (handler != null && this.f3030a.i != null) {
                handler2 = this.f3030a.n;
                handler2.removeCallbacks(this.f3030a.i);
            }
            com.baidu.platform.comapi.walknavi.b.a().a(1, false);
        }
    }
}
