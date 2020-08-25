package com.baidu.platform.comapi.wnplatform.i;

import com.baidu.mapapi.map.MapStatus;
import com.baidu.platform.comapi.walknavi.d.l;
import java.text.DecimalFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class h implements com.baidu.platform.comapi.wnplatform.k.b {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.k.b
    public void a(com.baidu.platform.comapi.wnplatform.model.datastruct.a aVar) {
        MapStatus j;
        int i;
        f.a();
        new DecimalFormat("######0.00");
        double d = aVar.d;
        double h = com.baidu.platform.comapi.walknavi.b.a().J().h();
        com.baidu.platform.comapi.walknavi.b.a().G().a(aVar.a, aVar.b, aVar.c, d, aVar.e, aVar.f);
        if (com.baidu.platform.comapi.walknavi.b.a().J().j() != null) {
            double d2 = aVar.d - h;
            com.baidu.platform.comapi.walknavi.d.e c = com.baidu.platform.comapi.walknavi.d.e.c();
            double a = l.a(j.overlook);
            if (d2 < 0.0d) {
                d2 += 360.0d;
            }
            c.a(a, l.a(d2) - 3.141592653589793d, 0.0d);
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
