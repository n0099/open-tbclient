package com.baidu.b.a.f.d;
/* loaded from: classes2.dex */
public class e {
    public static void a(com.baidu.b.a.c.a.a aVar, long j) {
        aVar.Zx = j;
        long d = com.baidu.b.a.c.b.a.rD().d(aVar);
        if (d != aVar.Zy) {
            aVar.Zy = d;
        }
    }

    public static void g(com.baidu.b.a.c.a.a aVar) {
        if (aVar.Zy <= 0) {
            aVar.type = 0;
        }
        long d = com.baidu.b.a.c.b.a.rD().d(aVar);
        if (d != aVar.Zy) {
            aVar.Zy = d;
        }
    }

    public static boolean h(com.baidu.b.a.c.a.a aVar) {
        if (aVar.Zy > 0) {
            aVar.Zy = 0L;
        }
        com.baidu.b.a.c.b.a.rD().j(aVar.channelId, aVar.packageName, "" + aVar.Zo);
        aVar.type = 0;
        long d = com.baidu.b.a.c.b.a.rD().d(aVar);
        if (d != aVar.Zy) {
            aVar.Zy = d;
        }
        return d > 0;
    }

    public static boolean i(com.baidu.b.a.c.a.a aVar) {
        if (aVar.Zy <= 0) {
            return false;
        }
        long d = com.baidu.b.a.c.b.a.rD().d(aVar);
        if (d != aVar.Zy) {
            aVar.Zy = d;
        }
        return d > 0;
    }

    public static boolean a(com.baidu.b.a.c.a.a aVar, int i) {
        if (aVar.type != i) {
            aVar.type = i;
            long d = com.baidu.b.a.c.b.a.rD().d(aVar);
            if (d != aVar.Zy) {
                aVar.Zy = d;
            }
            return true;
        }
        return false;
    }
}
