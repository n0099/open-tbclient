package com.baidu.adp.b;

import com.baidu.adp.lib.a.b.a.a.i;
/* loaded from: classes.dex */
public abstract class a extends i {
    private static volatile a EO = null;

    public abstract void b(String str, long j, long j2);

    public static a mA() {
        if (EO == null) {
            EO = new b();
        }
        return EO;
    }

    public static void a(a aVar) {
        EO = aVar;
    }
}
