package com.baidu.tbadk.core.voice.cache;

import android.content.Context;
/* loaded from: classes.dex */
public final class f {
    private static f a;
    private com.baidu.adp.lib.e.b b = com.baidu.adp.lib.e.b.a();

    private f() {
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (a == null) {
                a = new f();
            }
            fVar = a;
        }
        return fVar;
    }

    public final void a(Context context, String str) {
        this.b.a(str, context);
    }

    public final d a(Context context, String str, String str2, com.baidu.adp.lib.e.a<d> aVar) {
        try {
            com.baidu.adp.lib.e.e eVar = new com.baidu.adp.lib.e.e();
            eVar.a("from", str2);
            return (d) this.b.a(str, 4, aVar, context, eVar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
