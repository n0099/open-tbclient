package com.baidu.adp.lib.resourceLoader;

import com.baidu.adp.lib.stats.q;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class f {
    private static int a = 0;
    private static int b = 0;
    private static int c = 0;
    private static int d = 0;
    private static int e = 0;
    private static int f = 0;
    private static Object g = new Object();

    public static q a() {
        return com.baidu.adp.lib.stats.f.c().a("dbg");
    }

    public static void a(q qVar, q qVar2) {
        if (qVar != null || qVar2 != null) {
            synchronized (g) {
                if (qVar != null) {
                    c = (int) (c + qVar.b());
                }
                if (qVar2 != null) {
                    b = (int) (b + qVar2.b());
                }
                int i = a + 1;
                a = i;
                if (i + d > 100) {
                    b();
                }
            }
        }
    }

    public static void b(q qVar, q qVar2) {
        if (qVar != null || qVar2 != null) {
            synchronized (g) {
                if (qVar != null) {
                    f = (int) (f + qVar.b());
                }
                if (qVar2 != null) {
                    e = (int) (e + qVar2.b());
                }
                int i = d + 1;
                d = i;
                if (i + a > 100) {
                    b();
                }
            }
        }
    }

    public static void b() {
        if (a + d > 10) {
            q a2 = a();
            a2.a("act", "allStat");
            a2.a("diskTaskCostTime", String.valueOf(c));
            a2.a("diskCostTime", String.valueOf(b));
            a2.a("diskNum", String.valueOf(a));
            a2.a("netTaskCostTime", String.valueOf(f));
            a2.a("netCostTime", String.valueOf(e));
            a2.a("netNum", String.valueOf(d));
            a2.a("isWifi", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            com.baidu.adp.lib.stats.f.c().a("img", a2);
            b = 0;
            a = 0;
            e = 0;
            d = 0;
            c = 0;
            f = 0;
        }
    }
}
