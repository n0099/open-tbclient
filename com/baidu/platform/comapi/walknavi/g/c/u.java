package com.baidu.platform.comapi.walknavi.g.c;

import android.content.Context;
import com.baidu.platform.comapi.walknavi.g.c.c;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f4542a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.f4542a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.f4542a.f4541b.l;
        if (!com.baidu.platform.comapi.walknavi.d.a.g.g.d(context)) {
            context2 = this.f4542a.f4541b.l;
            if (context2 != null) {
                c cVar = this.f4542a.f4541b;
                String str = this.f4542a.f4540a;
                context3 = this.f4542a.f4541b.l;
                cVar.a(str, com.baidu.platform.comapi.wnplatform.p.a.a.b(context3, R.drawable.res_0x7f08001d_ic_icon_mask_guide_travel_svg__0), 4);
                return;
            }
            return;
        }
        this.f4542a.f4541b.a(this.f4542a.f4540a, (c.d) null);
    }
}
