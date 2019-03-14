package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes6.dex */
public class ab {
    private static h a;

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f A[Catch: all -> 0x0059, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0011, B:8:0x001a, B:9:0x0023, B:11:0x002f, B:12:0x003e, B:16:0x0050), top: B:28:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized h a(Context context) {
        h hVar;
        Class<?> a2;
        synchronized (ab.class) {
            bi.c().a("getBPStretegyController begin");
            h hVar2 = a;
            if (hVar2 == null) {
                try {
                    a2 = ae.a(context, "com.baidu.bottom.remote.BPStretegyController2");
                } catch (Exception e) {
                    e = e;
                }
                if (a2 != null) {
                    hVar = new ad(a2.newInstance());
                    try {
                        bi.c().a("Get BPStretegyController load remote class v2");
                    } catch (Exception e2) {
                        hVar2 = hVar;
                        e = e2;
                        bi.c().a(e);
                        hVar = hVar2;
                        if (hVar == null) {
                        }
                        a = hVar;
                        ae.a(context, hVar);
                        bi.c().a("getBPStretegyController end");
                        return hVar;
                    }
                    if (hVar == null) {
                        hVar = new ac();
                        bi.c().a("Get BPStretegyController load local class");
                    }
                    a = hVar;
                    ae.a(context, hVar);
                    bi.c().a("getBPStretegyController end");
                }
            }
            hVar = hVar2;
            if (hVar == null) {
            }
            a = hVar;
            ae.a(context, hVar);
            bi.c().a("getBPStretegyController end");
        }
        return hVar;
    }

    public static synchronized void a() {
        synchronized (ab.class) {
            a = null;
        }
    }
}
