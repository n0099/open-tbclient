package com.baidu.share;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private static b a = null;
    private g b = new g();
    private d c;

    private b(Context context) {
        this.c = null;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.c = new d(context);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b(context);
            }
            bVar = a;
        }
        return bVar;
    }

    public boolean a(a aVar) {
        return this.b.a(aVar);
    }

    public boolean a(c cVar) {
        return this.c.a(cVar);
    }

    public boolean a(c cVar, ArrayList arrayList) {
        return this.c.a(cVar, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(c cVar) {
        this.b.a(cVar);
    }

    public boolean b(a aVar) {
        return this.b.b(aVar);
    }
}
