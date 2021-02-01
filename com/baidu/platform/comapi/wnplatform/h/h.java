package com.baidu.platform.comapi.wnplatform.h;

import com.baidu.mapapi.map.MapStatus;
import com.baidu.platform.comapi.walknavi.d.l;
import java.text.DecimalFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class h implements com.baidu.platform.comapi.wnplatform.j.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f4419a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.f4419a = fVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.b
    public void a(com.baidu.platform.comapi.wnplatform.model.datastruct.a aVar) {
        MapStatus j;
        int i;
        f.a();
        new DecimalFormat("######0.00");
        double d = aVar.d;
        double h = com.baidu.platform.comapi.walknavi.b.a().G().h();
        com.baidu.platform.comapi.walknavi.b.a().D().a(aVar.f4440a, aVar.f4441b, aVar.c, d, aVar.e, aVar.f);
        if (com.baidu.platform.comapi.walknavi.b.a().G().j() != null) {
            double d2 = aVar.d - h;
            com.baidu.platform.comapi.walknavi.d.e c = com.baidu.platform.comapi.walknavi.d.e.c();
            double a2 = l.a(j.overlook);
            if (d2 < 0.0d) {
                d2 += 360.0d;
            }
            c.a(a2, l.a(d2) - 3.141592653589793d, 0.0d);
        }
        i = f.d;
        if (i % 5 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("s:" + ((int) d));
            sb.append("g:" + ((int) 0.0d));
            sb.append("r:" + ((int) h));
        }
    }
}
