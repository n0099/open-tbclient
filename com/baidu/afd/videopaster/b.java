package com.baidu.afd.videopaster;

import com.baidu.tieba.recapp.report.e;
import com.baidu.tieba.recapp.report.h;
/* loaded from: classes.dex */
public class b {
    public static void a(com.baidu.afd.videopaster.b.a aVar) {
        com.baidu.tieba.recapp.report.c o = h.o(aVar);
        o.Ic(aVar.acU);
        e.dEC().a(o);
    }

    public static void a(com.baidu.afd.videopaster.b.a aVar, String str) {
        com.baidu.tieba.recapp.report.c o = h.o(aVar);
        o.Sj(str);
        o.Ic(aVar.acU);
        e.dEC().a(o);
    }

    public static void a(com.baidu.afd.videopaster.b.a aVar, int i) {
        com.baidu.tieba.recapp.report.c o = h.o(aVar);
        o.Ic(aVar.acU);
        o.Id(aVar.acR);
        o.Ie(i);
        e.dEC().a(o);
    }

    public static void b(com.baidu.afd.videopaster.b.a aVar) {
        e.dEC().a(h.p(aVar));
    }

    public static void c(com.baidu.afd.videopaster.b.a aVar) {
        e.dEC().a(h.q(aVar));
    }

    public static void d(com.baidu.afd.videopaster.b.a aVar) {
        e.dEC().a(h.q(aVar));
    }

    public static void b(com.baidu.afd.videopaster.b.a aVar, int i) {
        com.baidu.tieba.recapp.report.c r = h.r(aVar);
        r.Ia(706);
        boolean z = i == 1000;
        r.Sj(z ? "APP" : "URL");
        if (!z) {
            r.Id(i);
        }
        r.Si("DEEPLINK");
        e.dEC().a(r);
    }
}
