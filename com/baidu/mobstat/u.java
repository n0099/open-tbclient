package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes14.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static a f3835a;

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f A[Catch: all -> 0x005b, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0011, B:8:0x001a, B:9:0x0023, B:11:0x002f, B:12:0x003e, B:17:0x0052), top: B:29:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized a a(Context context) {
        Exception exc;
        a aVar;
        a aVar2;
        Class<?> a2;
        synchronized (u.class) {
            bb.c().a("getBPStretegyController begin");
            a aVar3 = f3835a;
            if (aVar3 == null) {
                try {
                    a2 = x.a(context, "com.baidu.bottom.remote.BPStretegyController2");
                } catch (Exception e) {
                    exc = e;
                    aVar = aVar3;
                }
                if (a2 != null) {
                    aVar2 = new w(a2.newInstance());
                    try {
                        bb.c().a("Get BPStretegyController load remote class v2");
                    } catch (Exception e2) {
                        exc = e2;
                        aVar = aVar2;
                        bb.c().a(exc);
                        aVar2 = aVar;
                        if (aVar2 == null) {
                        }
                        f3835a = aVar2;
                        x.a(context, aVar2);
                        bb.c().a("getBPStretegyController end");
                        return aVar2;
                    }
                    if (aVar2 == null) {
                        aVar2 = new v();
                        bb.c().a("Get BPStretegyController load local class");
                    }
                    f3835a = aVar2;
                    x.a(context, aVar2);
                    bb.c().a("getBPStretegyController end");
                }
            }
            aVar2 = aVar3;
            if (aVar2 == null) {
            }
            f3835a = aVar2;
            x.a(context, aVar2);
            bb.c().a("getBPStretegyController end");
        }
        return aVar2;
    }

    public static synchronized void a() {
        synchronized (u.class) {
            f3835a = null;
        }
    }
}
