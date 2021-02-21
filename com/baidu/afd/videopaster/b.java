package com.baidu.afd.videopaster;

import com.baidu.tieba.recapp.report.e;
import com.baidu.tieba.recapp.report.h;
/* loaded from: classes.dex */
public class b {
    public static void a(com.baidu.afd.videopaster.b.a aVar) {
        com.baidu.tieba.recapp.report.c o = h.o(aVar);
        o.HY(aVar.aby);
        e.dEu().a(o);
    }

    public static void a(com.baidu.afd.videopaster.b.a aVar, String str) {
        com.baidu.tieba.recapp.report.c o = h.o(aVar);
        o.Sd(str);
        o.HY(aVar.aby);
        e.dEu().a(o);
    }

    public static void a(com.baidu.afd.videopaster.b.a aVar, int i) {
        com.baidu.tieba.recapp.report.c o = h.o(aVar);
        o.HY(aVar.aby);
        o.HZ(aVar.abv);
        o.Ia(i);
        e.dEu().a(o);
    }

    public static void b(com.baidu.afd.videopaster.b.a aVar) {
        e.dEu().a(h.p(aVar));
    }

    public static void c(com.baidu.afd.videopaster.b.a aVar) {
        e.dEu().a(h.q(aVar));
    }

    public static void d(com.baidu.afd.videopaster.b.a aVar) {
        e.dEu().a(h.q(aVar));
    }

    public static void b(com.baidu.afd.videopaster.b.a aVar, int i) {
        com.baidu.tieba.recapp.report.c r = h.r(aVar);
        r.HW(706);
        boolean z = i == 1000;
        r.Sd(z ? "APP" : "URL");
        if (!z) {
            r.HZ(i);
        }
        r.Sc("DEEPLINK");
        e.dEu().a(r);
    }
}
