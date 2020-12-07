package com.baidu.platform.comapi.walknavi.g.c;

import android.content.Context;
import com.baidu.platform.comapi.walknavi.g.c.c;
import com.baidu.tieba.R;
/* loaded from: classes26.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f3049a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.f3049a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.f3049a.b.l;
        if (!com.baidu.platform.comapi.walknavi.d.a.g.g.d(context)) {
            context2 = this.f3049a.b.l;
            if (context2 != null) {
                c cVar = this.f3049a.b;
                String str = this.f3049a.f3048a;
                context3 = this.f3049a.b.l;
                cVar.a(str, com.baidu.platform.comapi.wnplatform.p.a.a.b(context3, R.raw.lottie_card_agree_2), 4);
                return;
            }
            return;
        }
        this.f3049a.b.a(this.f3049a.f3048a, (c.d) null);
    }
}
