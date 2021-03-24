package com.baidu.platform.comapi.wnplatform.h;

import com.baidu.mapapi.map.MapStatus;
import com.baidu.platform.comapi.walknavi.d.l;
import java.text.DecimalFormat;
/* loaded from: classes2.dex */
public class h implements com.baidu.platform.comapi.wnplatform.j.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f10286a;

    public h(f fVar) {
        this.f10286a = fVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.b
    public void a(com.baidu.platform.comapi.wnplatform.model.datastruct.a aVar) {
        MapStatus j;
        double d2;
        int i;
        f.a();
        new DecimalFormat("######0.00");
        double d3 = aVar.f10326d;
        double h2 = com.baidu.platform.comapi.walknavi.b.a().G().h();
        com.baidu.platform.comapi.walknavi.b.a().D().a(aVar.f10323a, aVar.f10324b, aVar.f10325c, d3, aVar.f10327e, aVar.f10328f);
        if (com.baidu.platform.comapi.walknavi.b.a().G().j() != null) {
            double d4 = aVar.f10326d;
            Double.isNaN(h2);
            d2 = h2;
            double d5 = d4 - d2;
            com.baidu.platform.comapi.walknavi.d.e c2 = com.baidu.platform.comapi.walknavi.d.e.c();
            double a2 = l.a(j.overlook);
            if (d5 < 0.0d) {
                d5 += 360.0d;
            }
            c2.a(a2, l.a(d5) - 3.141592653589793d, 0.0d);
        } else {
            d2 = h2;
        }
        i = f.f10279d;
        if (i % 5 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("s:" + ((int) d3));
            sb.append("g:" + ((int) 0.0d));
            sb.append("r:" + ((int) d2));
        }
    }
}
