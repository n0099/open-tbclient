package com.baidu.platform.comapi.wnplatform.h;

import com.baidu.mapapi.map.MapStatus;
import com.baidu.platform.comapi.walknavi.d.l;
import java.text.DecimalFormat;
/* loaded from: classes2.dex */
public class h implements com.baidu.platform.comapi.wnplatform.j.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f10287a;

    public h(f fVar) {
        this.f10287a = fVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.b
    public void a(com.baidu.platform.comapi.wnplatform.model.datastruct.a aVar) {
        MapStatus j;
        int i;
        f.a();
        new DecimalFormat("######0.00");
        double d2 = aVar.f10327d;
        double h2 = com.baidu.platform.comapi.walknavi.b.a().G().h();
        com.baidu.platform.comapi.walknavi.b.a().D().a(aVar.f10324a, aVar.f10325b, aVar.f10326c, d2, aVar.f10328e, aVar.f10329f);
        if (com.baidu.platform.comapi.walknavi.b.a().G().j() != null) {
            double d3 = aVar.f10327d - h2;
            com.baidu.platform.comapi.walknavi.d.e c2 = com.baidu.platform.comapi.walknavi.d.e.c();
            double a2 = l.a(j.overlook);
            if (d3 < 0.0d) {
                d3 += 360.0d;
            }
            c2.a(a2, l.a(d3) - 3.141592653589793d, 0.0d);
        }
        i = f.f10280d;
        if (i % 5 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("s:" + ((int) d2));
            sb.append("g:" + ((int) 0.0d));
            sb.append("r:" + ((int) h2));
        }
    }
}
