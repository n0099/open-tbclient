package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes2.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static a f8922a;

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a A[Catch: all -> 0x0058, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0010, B:8:0x0018, B:9:0x0021, B:15:0x0030, B:18:0x003a, B:19:0x0048), top: B:29:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized a a(Context context) {
        a aVar;
        a aVar2;
        Exception e2;
        Class<?> a2;
        synchronized (u.class) {
            bb.c().a("getBPStretegyController begin");
            aVar = f8922a;
            if (aVar == null) {
                try {
                    a2 = x.a(context, "com.baidu.bottom.remote.BPStretegyController2");
                } catch (Exception e3) {
                    aVar2 = aVar;
                    e2 = e3;
                }
                if (a2 != null) {
                    aVar2 = new w(a2.newInstance());
                    try {
                        bb.c().a("Get BPStretegyController load remote class v2");
                    } catch (Exception e4) {
                        e2 = e4;
                        bb.c().a(e2);
                        aVar = aVar2;
                        if (aVar == null) {
                        }
                        f8922a = aVar;
                        x.a(context, aVar);
                        bb.c().a("getBPStretegyController end");
                        return aVar;
                    }
                    aVar = aVar2;
                }
            }
            if (aVar == null) {
                aVar = new v();
                bb.c().a("Get BPStretegyController load local class");
            }
            f8922a = aVar;
            x.a(context, aVar);
            bb.c().a("getBPStretegyController end");
        }
        return aVar;
    }

    public static synchronized void a() {
        synchronized (u.class) {
            f8922a = null;
        }
    }
}
