package com.baidu.adp.b;

import com.baidu.adp.lib.a.b.a.a.i;
/* loaded from: classes.dex */
public abstract class a extends i {
    private static volatile a Ff = null;

    public abstract void b(String str, long j, long j2);

    public static a mD() {
        if (Ff == null) {
            Ff = new b();
        }
        return Ff;
    }

    public static void a(a aVar) {
        Ff = aVar;
    }
}
