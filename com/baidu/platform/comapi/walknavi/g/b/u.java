package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.platform.comapi.walknavi.g.b.c;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f2991a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.f2991a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.f2991a.b.l;
        if (!NetworkUtil.isWifiState(context)) {
            context2 = this.f2991a.b.l;
            if (context2 != null) {
                c cVar = this.f2991a.b;
                String str = this.f2991a.f2990a;
                context3 = this.f2991a.b.l;
                cVar.a(str, com.baidu.platform.comapi.wnplatform.o.a.a.b(context3, R.drawable.res_0x7f08001d_ic_icon_mask_guide_travel_svg__0), 4);
                return;
            }
            return;
        }
        this.f2991a.b.a(this.f2991a.f2990a, (c.d) null);
    }
}
