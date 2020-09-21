package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes15.dex */
public class u {
    private static a a;

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f A[Catch: all -> 0x0059, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0011, B:8:0x001a, B:9:0x0023, B:11:0x002f, B:12:0x003e, B:16:0x0050), top: B:28:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized a a(Context context) {
        a aVar;
        Class<?> a2;
        synchronized (u.class) {
            bb.c().a("getBPStretegyController begin");
            a aVar2 = a;
            if (aVar2 == null) {
                try {
                    a2 = x.a(context, "com.baidu.bottom.remote.BPStretegyController2");
                } catch (Exception e) {
                    e = e;
                }
                if (a2 != null) {
                    aVar = new w(a2.newInstance());
                    try {
                        bb.c().a("Get BPStretegyController load remote class v2");
                    } catch (Exception e2) {
                        aVar2 = aVar;
                        e = e2;
                        bb.c().a(e);
                        aVar = aVar2;
                        if (aVar == null) {
                        }
                        a = aVar;
                        x.a(context, aVar);
                        bb.c().a("getBPStretegyController end");
                        return aVar;
                    }
                    if (aVar == null) {
                        aVar = new v();
                        bb.c().a("Get BPStretegyController load local class");
                    }
                    a = aVar;
                    x.a(context, aVar);
                    bb.c().a("getBPStretegyController end");
                }
            }
            aVar = aVar2;
            if (aVar == null) {
            }
            a = aVar;
            x.a(context, aVar);
            bb.c().a("getBPStretegyController end");
        }
        return aVar;
    }

    public static synchronized void a() {
        synchronized (u.class) {
            a = null;
        }
    }
}
