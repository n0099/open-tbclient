package com.baidu.adp.b;

import com.baidu.adp.lib.a.b.a.a.i;
/* loaded from: classes.dex */
public abstract class a extends i {
    private static volatile a EN = null;

    public abstract void b(String str, long j, long j2);

    public static a mq() {
        if (EN == null) {
            EN = new b();
        }
        return EN;
    }

    public static void a(a aVar) {
        EN = aVar;
    }
}
