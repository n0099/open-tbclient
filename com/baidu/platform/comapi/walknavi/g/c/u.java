package com.baidu.platform.comapi.walknavi.g.c;

import android.content.Context;
import com.baidu.platform.comapi.walknavi.g.c.c;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
class u implements Runnable {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.a.b.l;
        if (!com.baidu.platform.comapi.walknavi.d.a.g.g.d(context)) {
            context2 = this.a.b.l;
            if (context2 != null) {
                c cVar = this.a.b;
                String str = this.a.a;
                context3 = this.a.b.l;
                cVar.a(str, com.baidu.platform.comapi.wnplatform.p.a.a.b(context3, R.raw.lottie_common_pull_refresh_2), 4);
                return;
            }
            return;
        }
        this.a.b.a(this.a.a, (c.d) null);
    }
}
