package com.baidu.platform.comapi.walknavi.g.c;

import android.os.Handler;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class d extends com.baidu.platform.comapi.wnplatform.p.n {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.p.n
    public void a(View view) {
        Handler handler;
        Handler handler2;
        if (com.baidu.platform.comapi.walknavi.b.a().w()) {
            handler = this.a.n;
            if (handler != null && this.a.i != null) {
                handler2 = this.a.n;
                handler2.removeCallbacks(this.a.i);
            }
            com.baidu.platform.comapi.walknavi.b.a().a(1, false);
        }
    }
}
