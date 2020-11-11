package com.baidu.platform.comapi.walknavi.g.c;

import android.content.Context;
import com.baidu.platform.comapi.walknavi.g.c.c;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f3047a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.f3047a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.f3047a.b.l;
        if (!com.baidu.platform.comapi.walknavi.d.a.g.g.d(context)) {
            context2 = this.f3047a.b.l;
            if (context2 != null) {
                c cVar = this.f3047a.b;
                String str = this.f3047a.f3046a;
                context3 = this.f3047a.b.l;
                cVar.a(str, com.baidu.platform.comapi.wnplatform.p.a.a.b(context3, R.raw.lottie_common_pull_refresh_2), 4);
                return;
            }
            return;
        }
        this.f3047a.b.a(this.f3047a.f3046a, (c.d) null);
    }
}
