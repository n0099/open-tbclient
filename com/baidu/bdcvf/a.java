package com.baidu.bdcvf;

import android.content.Context;
/* loaded from: classes.dex */
public final class a {
    private static volatile a a = null;
    private static boolean b = false;

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                    if (b()) {
                        b bVar = new b();
                        bVar.a(1);
                        bVar.a();
                    }
                }
            }
        }
        return a;
    }

    private a() {
    }

    private static boolean b() {
        return b;
    }

    public void a(Context context, c cVar) {
        try {
            N.a(context, cVar);
        } catch (Throwable th) {
            try {
                cVar.a();
            } catch (Exception e) {
                cVar.a(2);
            }
        }
    }
}
