package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.platform.comapi.walknavi.g.b.c;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t f10035a;

    public u(t tVar) {
        this.f10035a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.f10035a.f10034b.l;
        if (!NetworkUtil.isWifiState(context)) {
            context2 = this.f10035a.f10034b.l;
            if (context2 != null) {
                t tVar = this.f10035a;
                c cVar = tVar.f10034b;
                String str = tVar.f10033a;
                context3 = cVar.l;
                cVar.a(str, com.baidu.platform.comapi.wnplatform.o.a.a.b(context3, R.drawable.res_0x7f08001d_ic_icon_mask_guide_travel_svg__0), 4);
                return;
            }
            return;
        }
        t tVar2 = this.f10035a;
        tVar2.f10034b.a(tVar2.f10033a, (c.d) null);
    }
}
