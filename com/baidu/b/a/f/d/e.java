package com.baidu.b.a.f.d;
/* loaded from: classes2.dex */
public class e {
    public static void a(com.baidu.b.a.c.a.a aVar, long j) {
        aVar.ZG = j;
        long d = com.baidu.b.a.c.b.a.rG().d(aVar);
        if (d != aVar.ZH) {
            aVar.ZH = d;
        }
    }

    public static void g(com.baidu.b.a.c.a.a aVar) {
        if (aVar.ZH <= 0) {
            aVar.type = 0;
        }
        long d = com.baidu.b.a.c.b.a.rG().d(aVar);
        if (d != aVar.ZH) {
            aVar.ZH = d;
        }
    }

    public static boolean h(com.baidu.b.a.c.a.a aVar) {
        if (aVar.ZH > 0) {
            aVar.ZH = 0L;
        }
        com.baidu.b.a.c.b.a.rG().j(aVar.channelId, aVar.packageName, "" + aVar.Zx);
        aVar.type = 0;
        long d = com.baidu.b.a.c.b.a.rG().d(aVar);
        if (d != aVar.ZH) {
            aVar.ZH = d;
        }
        return d > 0;
    }

    public static boolean i(com.baidu.b.a.c.a.a aVar) {
        if (aVar.ZH <= 0) {
            return false;
        }
        long d = com.baidu.b.a.c.b.a.rG().d(aVar);
        if (d != aVar.ZH) {
            aVar.ZH = d;
        }
        return d > 0;
    }

    public static boolean a(com.baidu.b.a.c.a.a aVar, int i) {
        if (aVar.type != i) {
            aVar.type = i;
            long d = com.baidu.b.a.c.b.a.rG().d(aVar);
            if (d != aVar.ZH) {
                aVar.ZH = d;
            }
            return true;
        }
        return false;
    }
}
