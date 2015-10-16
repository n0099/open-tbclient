package com.baidu.adp.b;

import com.baidu.adp.lib.a.b.a.a.i;
/* loaded from: classes.dex */
public abstract class a extends i {
    private static volatile a EP = null;

    public abstract void b(String str, long j, long j2);

    public static a my() {
        if (EP == null) {
            EP = new b();
        }
        return EP;
    }

    public static void a(a aVar) {
        EP = aVar;
    }
}
